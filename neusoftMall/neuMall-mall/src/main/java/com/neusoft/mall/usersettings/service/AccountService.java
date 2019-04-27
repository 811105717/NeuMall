package com.neusoft.mall.usersettings.service;

import com.neusoft.common.entity.CustomerInfo;
import com.neusoft.common.response.AppResponse;
import java.io.UnsupportedEncodingException;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 13:13
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@SuppressWarnings("ALL")
public interface AccountService {
    /**
     * 更新用户密码
     * @param customer 用户对象
     * @return 结果
     * @throws UnsupportedEncodingException 抛出编码失败异常
     */
    AppResponse updatePassword(CustomerInfo customer) throws UnsupportedEncodingException;

    /**
     * 用户注册
     * @param customer 用户对象
     * @return 结果
     * @throws UnsupportedEncodingException 抛出编码失败异常
     */
    AppResponse customerRegister(CustomerInfo customer) throws UnsupportedEncodingException;

    /**
     * 用户登录
     * @param customer 用户对象
     * @return 结果
     * @throws UnsupportedEncodingException 抛出编码失败异常
     */
    AppResponse customerLogin(CustomerInfo customer) throws UnsupportedEncodingException;
}
