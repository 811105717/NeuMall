package com.neusoft.mall.usersettings.controller;

import com.neusoft.common.util.CreateMD5;
import com.neusoft.common.util.UUIDUtil;
import com.neusoft.mall.entity.UserInfo;
import com.neusoft.mall.usersettings.service.UserSettingService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/front/passWord")
public class UserSettingController {

    @Autowired
    private UserSettingService userSettingService;

    /**
     * @Dept：大连东软信息学院
     * @Description：修改密码
     * @Author：xiaobai
     * @Date: 2019/4/9
     * @Param：customerId 客户ID
     *  customerNewPassword 新密码
     *  customerPassword 原密码
     * @Return：java.util.Map<java.lang.String,java.lang.Object>
     */
    @PutMapping(value = "updatePassWord")
    public Map<String,Object> updatePassWord(String customerId,
                                             String customerNewPassword,
                                             String customerPassword) throws Exception{
        HashMap<String, Object> map = new HashMap<>(16);
        //检查用户是否存在  存在则修改密码  不存在则提示不存在
        UserInfo user = userSettingService.checkUser(customerId, customerPassword);
        if(null==user){
            map.put("code",4);
            map.put("msg","原始密码错误！");
            map.put("data","");
        }else {
            Integer res = userSettingService.updateUser(customerId,customerNewPassword);
            if (res > 0) {
                map.put("code", 0);
                map.put("msg", "密码修改成功！");
                map.put("data", "");
            } else {
                map.put("code",1);
                map.put("msg","修改密码失败！");
                map.put("data","");
            }
        }

        return map;
    }

}
