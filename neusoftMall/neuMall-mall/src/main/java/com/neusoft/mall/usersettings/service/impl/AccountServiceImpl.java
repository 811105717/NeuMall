package com.neusoft.mall.usersettings.service.impl;

import com.neusoft.common.entity.CustomerInfo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.common.util.CreateMD5;
import com.neusoft.common.util.UUIDUtil;

import com.neusoft.mall.usersettings.mapper.AccountMapper;
import com.neusoft.mall.usersettings.service.AccountService;

import com.neusoft.mall.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    /**
     * 数据操作对象
     */
    @Autowired
    private AccountMapper mapper;

    /**
     * redis工具对象
     */
    @Autowired
    private RedisUtil<CustomerInfo> redisUtil;


    /**
     * @Dept 大连东软信息学院
     * @Description  修改密码逻辑处理
     * @author xiaobai
     * @date 2019/4/10
     * @param customer 当前用户
     * @return com.neusoft.common.response.AppResponse
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public AppResponse updatePassword(CustomerInfo customer) throws UnsupportedEncodingException {
        CustomerInfo currCustomer = (CustomerInfo) redisUtil.getData(customer.getTokenFront());
        if(null == currCustomer){
            return AppResponse.bizError("token 失效");
        }
        customer.setCustomerId(currCustomer.getCustomerId());
        if(null != customer.getCustomerPassword() && !"".equals(customer.getCustomerPassword())){
            //查找用户
            CustomerInfo checkCustomer = mapper.getCustomerById(customer.getCustomerId());
            if(null == checkCustomer){
                return AppResponse.bizError("用户不存在或者已经被删除！");
            }else if (!CreateMD5.getMd5(customer.getCustomerPassword()).
                    equals(checkCustomer.getCustomerPassword())){
                //比对旧密码
                //若用户存在，且密码与当前密码不匹配
                return AppResponse.bizError("原密码不匹配，请重新输入");
            }else {
                customer.setLastModifiedBy(currCustomer.getCustomerName());
                //更新密码（加密）
                customer.setCustomerPassword(CreateMD5.getMd5(customer.getCustomerNewPassword()));
                int result = mapper.updatePassword(customer);
                //根据结果返回
                if (0 == result) {
                    return AppResponse.bizError("修改密码失败，请重试！");
                }
                return AppResponse.success("修改密码成功！");
            }
        }else {
            return AppResponse.bizError("未知参数错误！");
        }
    }

    /**
     * @Dept 大连东软信息学院
     * @Description 用户注册逻辑处理
     * @author xiaobai
     * @date 2019/4/10
     * @param customer 被注册用户
     * @return com.neusoft.common.response.AppResponse
     */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public AppResponse customerRegister(CustomerInfo customer) throws UnsupportedEncodingException {
        //先检查用户账号是否存在
        if(null != customer.getCustomerNumber() && !"".equals(customer.getCustomerNumber())){
            Integer count = mapper.checkExistCustomer(customer.getCustomerNumber());
            if(0 != count){
                return AppResponse.bizError("用户名已经存在！请更换！");
            }else {
                //对用户进行一些处理  然后存入数据库
                customer.setLastModifiedBy(customer.getCustomerName());
                customer.setCustomerId(UUIDUtil.uuidStr());
                customer.setCustomerPassword(CreateMD5.getMd5(customer.getCustomerPassword()));
                Integer res = mapper.addCustomer(customer);
                //根据结果返回
                if(0 == res){
                    return AppResponse.bizError("用户注册失败！");
                }else {
                    return AppResponse.success("用户注册成功！");
                }
            }
        }else {
            return AppResponse.bizError("未知参数错误！");
        }
    }

    /**
     * @Dept 大连东软信息学院
     * @Description 用户登录逻辑处理
     * @author xiaobai
     * @date 2019/4/10
     * @param customer 登录用户
     * @return com.neusoft.common.response.AppResponse
     */

    @Override
    public AppResponse customerLogin(CustomerInfo customer)
            throws UnsupportedEncodingException {
        if(null != customer.getCustomerPassword() && !"".equals(customer.getCustomerPassword()) ){
            //对密码进行加密转换 然后查询
            customer.setCustomerPassword(CreateMD5.getMd5(customer.getCustomerPassword()));
            CustomerInfo logInCustomer = mapper.userLogin(customer);
            if (null == logInCustomer){
                return AppResponse.bizError("用户登录失败，用户名或密码错误！");
            }else {
                //若账户存在 则为账户生成token 然后将账户存入redis 并跟新存活时间
                //所有操作全部完成才认为用户登陆成功
                logInCustomer.setTokenFront(RedisUtil.generateToken());
                boolean res1 = redisUtil.addData(logInCustomer.getTokenFront(),logInCustomer);
                boolean res2 = redisUtil.updateActiveTime(logInCustomer.getTokenFront());
                if(res1 && res2){
                    //放入redis成功后 设置customerId 与 password失效 然后返回给前端
                    logInCustomer.setCustomerId(null);
                    logInCustomer.setCustomerPassword(null);
                    log.info("用户登陆成功  放入redis token {}",logInCustomer.getTokenFront());
                    return AppResponse.success("用户登录成功！",logInCustomer);
                }
                return AppResponse.bizError("放入redis失败 拒绝登陆！");
            }
        }else {
            return AppResponse.bizError("未知参数错误！");
        }
    }
}
