package com.neusoft.mall.usersettings.mapper;

import com.neusoft.mall.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 13:15
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@Mapper
@Component
public interface UserSettingMapper {
    UserInfo checkUser(@Param("id") String id, @Param("pwd") String pwd);
    Integer updateUser(@Param("id")String id, @Param("newPwd")String newPwd);
}
