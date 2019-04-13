package com.neusoft.mall.usersettings.mapper;

import com.neusoft.mall.entity.CustomerInfo;
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
@SuppressWarnings("ALL")
@Mapper
@Component
public interface AccountMapper {
    /**
     * @Dept：大连东软信息学院
     * @Description：检查用户是否存在
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：number 用户编号 （用户名）
     * @Return：java.lang.Integer
     */
    Integer checkExistCustomer (@Param("number") String number);
    /**
     * @Dept：大连东软信息学院
     * @Description：用户注册
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：customer 被注册的用户
     * @Return：java.lang.Integer
     */
    Integer addCustomer(CustomerInfo customer);
    /**
     * @Dept：大连东软信息学院
     * @Description： 更新密码
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：customer 修改密码的用户
     * @Return：java.lang.Integer
     */
    Integer updatePassword(CustomerInfo customer);
    /**
     * @Dept：大连东软信息学院
     * @Description： 用户登录
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：customer 登录用户
     * @Return：com.neusoft.mall.entity.CustomerInfo
     */
    CustomerInfo userLogin(CustomerInfo customer);
    /**
     * @Dept：大连东软信息学院
     * @Description： 根据Id 查询用户
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：id 用户id
     * @Return：com.neusoft.mall.entity.CustomerInfo
     */
    CustomerInfo getCustomerById(@Param("id") String id);
}
