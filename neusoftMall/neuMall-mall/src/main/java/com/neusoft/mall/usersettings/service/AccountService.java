package com.neusoft.mall.usersettings.service;

import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.CustomerInfo;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 13:13
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
public interface AccountService {
    AppResponse updatePassword(CustomerInfo customer) throws UnsupportedEncodingException;
    AppResponse customerRegister(CustomerInfo customer) throws UnsupportedEncodingException;
    AppResponse customerLogin(CustomerInfo customer)
            throws UnsupportedEncodingException;
}
