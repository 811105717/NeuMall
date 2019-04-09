package com.neusoft.mall.usersettings.service;

import com.neusoft.mall.entity.CustomerInfo;

import java.io.UnsupportedEncodingException;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 13:13
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
public interface AccountService {
    CustomerInfo checkUser(String id, String pass) throws UnsupportedEncodingException;
    Integer updateUser(String id, String newPass) throws UnsupportedEncodingException;
    CustomerInfo userLogin(String customerNumber, String pwd) throws UnsupportedEncodingException;
}
