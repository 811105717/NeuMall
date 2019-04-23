package com.neusoft.mall.usersettings.service.impl;

import com.neusoft.common.response.AppResponse;
import com.neusoft.common.util.CreateMD5;
import com.neusoft.common.util.UUIDUtil;
import com.neusoft.mall.entity.CustomerInfo;
import com.neusoft.mall.usersettings.mapper.AccountMapper;
import com.neusoft.mall.usersettings.service.AccountService;
import com.neusoft.mall.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 13:13
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@SuppressWarnings("ALL")
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;
    @Autowired
    private RedisUtil redisUtil;


    /**
     * @Dept：大连东软信息学院
     * @Description： 修改密码逻辑处理
     * @Author：xiaobai
     * @Date: 2019/4/10
     * @Param：customer 当前用户
     * @Return：com.neusoft.common.response.AppResponse
     */
    @Transactional
    @Override
    public AppResponse updatePassword(CustomerInfo customer) throws UnsupportedEncodingException {
        //从redis取出当前登录用户
        CustomerInfo currCustomer = (CustomerInfo) redisUtil.getData(customer.getTokenFront());
        if(null == currCustomer){
            return AppResponse.bizError("无效的TOKEN！");
        }
        log.info("get custoner by redis {}",currCustomer);
        //判断密码是否为空
        if(null!= customer.getCustomerPassword()&& !"".equals(customer.getCustomerPassword())){
            //查找相应用户
            CustomerInfo checkCustomer = mapper.getCustomerById(currCustomer.getCustomerId());
            if(null == checkCustomer){
                return AppResponse.bizError("用户不存在或者已经被删除！");
            }else if (!CreateMD5.getMd5(customer.getCustomerPassword()).
                    equals(checkCustomer.getCustomerPassword())){
                //若用户存在，且密码与当前密码不匹配
                return AppResponse.bizError("原密码不匹配，请重新输入");
            }else {
                //修改密码  写入数据库
                customer.setCustomerId(currCustomer.getCustomerId());
                customer.setLastModifiedBy(currCustomer.getCustomerName());
                customer.setCustomerPassword(CreateMD5.getMd5(customer.getCustomerNewPassword()));
                int result = mapper.updatePassword(customer);
                if (0 == result) {
                    return AppResponse.bizError("修改密码失败，请重试！");
                }
                return AppResponse.success("修改密码成功！");
            }
        }else {
            //前端数据为空走这里！
            return AppResponse.bizError("未知数据错误！");
        }
    }

    /**
     * @Dept：大连东软信息学院
     * @Description： 用户注册逻辑处理
     * @Author：xiaobai
     * @Date: 2019/4/10
     * @Param：customer 被注册用户
     * @Return：com.neusoft.common.response.AppResponse
     */

    @Transactional
    @Override
    public AppResponse customerRegister(CustomerInfo customer) throws UnsupportedEncodingException {
        //检查用户账号是否重复
        if(null != customer.getCustomerNumber() && !"".equals(customer.getCustomerNumber())){
            Integer count = mapper.checkExistCustomer(customer.getCustomerNumber());
            if(0 != count){
                return AppResponse.bizError("用户名已经存在！请更换！");
            }else {
                //对用户进行一些处理  然后存入数据库
                customer.setLastModifiedBy(customer.getCustomerId());
                customer.setCustomerId(UUIDUtil.uuidStr());
                customer.setCustomerPassword(CreateMD5.getMd5(customer.getCustomerPassword()));
                Integer res = mapper.addCustomer(customer);
                if(0 == res){
                    return AppResponse.bizError("用户注册失败！");
                }else {
                    return AppResponse.success("用户注册成功！");
                }
            }
        }else {
            return AppResponse.bizError("未知数据错误！");
        }
    }

    /**
     * @Dept：大连东软信息学院
     * @Description： 用户登录逻辑处理
     * @Author：xiaobai
     * @Date: 2019/4/10
     * @Param：customer 登录用户
     * @Return：com.neusoft.common.response.AppResponse
     */

    @Override
    public AppResponse customerLogin(CustomerInfo customer)
            throws UnsupportedEncodingException {
        //判断用户名
        if(null != customer.getCustomerPassword() && !"".equals(customer.getCustomerPassword()) ){
            customer.setCustomerPassword(CreateMD5.getMd5(customer.getCustomerPassword()));
            CustomerInfo logInCustomer = mapper.userLogin(customer);
            if (null == logInCustomer){
                //如果登陆失败  可能用户不存在  也可能密码错误
                return AppResponse.bizError("用户登录失败，用户名或密码错误！");
            }else {
                //放入token

                logInCustomer.setTokenFront(RedisUtil.generateToken());
                boolean res1 = redisUtil.addData(logInCustomer.getTokenFront(),logInCustomer);
                boolean res2 = redisUtil.updateActiveTime(logInCustomer.getTokenFront());
                if(res1 && res2){
                    //放入redis成功后 设置customerId 与 password失效
                    logInCustomer.setCustomerId(null);
                    logInCustomer.setCustomerPassword(null);
                    log.info("用户登陆成功  放入redis token {}",logInCustomer.getTokenFront());
                    return AppResponse.success("用户登录成功！",logInCustomer);
                }
                return AppResponse.bizError("放入redis失败 拒绝登陆！");
            }
        }else {
            return AppResponse.bizError("未知数据错误！");
        }
    }
}
