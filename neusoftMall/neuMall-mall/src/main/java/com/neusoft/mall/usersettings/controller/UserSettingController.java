package com.neusoft.mall.usersettings.controller;

import com.neusoft.mall.usersettings.service.UserSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
