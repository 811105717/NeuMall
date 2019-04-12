package com.neusoft.mall.usersettings.service.impl;

import com.neusoft.common.response.AppResponse;
import com.neusoft.common.util.CreateMD5;
import com.neusoft.common.util.UUIDUtil;
import com.neusoft.mall.entity.CustomerInfo;
import com.neusoft.mall.usersettings.mapper.AccountMapper;
import com.neusoft.mall.usersettings.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 13:13
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;

    /**
     * @Dept：大连东软信息学院
     * @Description： 修改密码逻辑处理
     * @Author：xiaobai
     * @Date: 2019/4/10
     * @Param：customer
     * @Return：com.neusoft.common.response.AppResponse
     */
    @Transactional
    @Override
    public AppResponse updatePassword(CustomerInfo customer) throws UnsupportedEncodingException {
        //判断密码是否为空
        if(null!= customer.getCustomerPassword()&& !"".equals(customer.getCustomerPassword())){
            //查找相应用户
            CustomerInfo checkCustomer = mapper.getCustomerById(customer.getCustomerId());
            if(null == checkCustomer){
                return AppResponse.bizError("用户不存在或者已经被删除！");
            }else if (!CreateMD5.getMd5(customer.getCustomerPassword()).
                    equals(checkCustomer.getCustomerPassword())){
                //若用户存在，且密码与当前密码不匹配
                return AppResponse.bizError("原密码不匹配，请重新输入");
            }else {
                //修改密码  写入数据库
                customer.setCustomerPassword(CreateMD5.getMd5(customer.getCustomerPassword()));
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
     * @Param：customer
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
     * @Param：customer
     * @Return：com.neusoft.common.response.AppResponse
     */

    @Override
    public AppResponse customerLogin(CustomerInfo customer, HttpServletRequest request)
            throws UnsupportedEncodingException {
        //判断用户名
        if(null != customer.getCustomerPassword() && !"".equals(customer.getCustomerPassword()) ){
            customer.setCustomerPassword(CreateMD5.getMd5(customer.getCustomerPassword()));
            CustomerInfo logInCustomer = mapper.userLogin(customer);
            if (null == logInCustomer){
                //如果登陆失败  可能用户不存在  也可能密码错误
                return AppResponse.bizError("用户登录失败，用户名或密码错误！");
            }else {
                //登录成功  处理session
                HttpSession session = request.getSession();
                session.setAttribute("_LOGIN_USER_",logInCustomer);
                return AppResponse.success("用户登录成功！");
            }
        }else {
            return AppResponse.bizError("未知数据错误！");
        }
    }
}