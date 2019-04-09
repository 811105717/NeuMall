package com.neusoft.mall.usersettings.service.impl;

import com.neusoft.mall.usersettings.mapper.UserSettingMapper;
import com.neusoft.mall.usersettings.service.UserSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    @Override
    public Integer updatePassWord(String id,String newPassWord,String passWord) {
        return mapper.updatePassWord(id,newPassWord,passWord);
    }
}
