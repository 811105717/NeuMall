package com.neusoft.mall.usersettings.service.impl;

import com.neusoft.common.util.CreateMD5;
import com.neusoft.mall.entity.UserInfo;
import com.neusoft.mall.usersettings.mapper.UserSettingMapper;
import com.neusoft.mall.usersettings.service.UserSettingService;
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
@Service
public class UserSettingServiceImpl implements UserSettingService {

    @Autowired
    private UserSettingMapper mapper;

    /**
     * @Dept：大连东软信息学院
     * @Description：检查用户是否安全
     * @Author：xiaobai
     * @Date: 2019/4/9
     * @Return：com.neusoft.mall.entity.UserInfo
     */
    @Override
    public UserInfo checkUser(String id, String pass) throws UnsupportedEncodingException {
        return mapper.checkUser(id, CreateMD5.getMd5(pass));
    }

    /**
     * @Dept：大连东软信息学院
     * @Description： 修改用户密码
     * @Author：xiaobai
     * @Date: 2019/4/9
     * @Param：id
     * @Return：java.lang.Integer
     */
    @Transactional
    @Override
    public Integer updateUser(String id, String newPass) throws UnsupportedEncodingException {
        return mapper.updateUser(id,CreateMD5.getMd5(newPass));
    }


}
