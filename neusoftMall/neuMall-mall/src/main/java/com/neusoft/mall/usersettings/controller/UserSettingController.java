package com.neusoft.mall.usersettings.controller;

import com.neusoft.mall.usersettings.service.UserSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 13:12
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@RestController
@RequestMapping("/front/passWord")
public class UserSettingController {

    @Autowired
    private UserSettingService userSettingService;

    @PutMapping(value = "updatePassWord")
    public Map<String,Object> updatePassWord(String customerId,
                                             String customerNewPassword,
                                             String customerPassword){
        HashMap<String, Object> map = new HashMap<>(16);



        return map;
    }

}
