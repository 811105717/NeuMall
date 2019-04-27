package com.neusoft.mall.usersettings.mapper;

import com.neusoft.common.entity.CustomerInfo;
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
     * 查询用户账号是否存在
     * @param number 用户账号
     * @return 结果
     */
    Integer checkExistCustomer (@Param("number") String number);

    /**
     * 添加用户 （注册）
     * @param customer 用户对象
     * @return 添加结果
     */
    Integer addCustomer(CustomerInfo customer);

    /**
     * 更新用户密码
     * @param customer 用户对象
     * @return 更新结果
     */
    Integer updatePassword(CustomerInfo customer);

    /**
     * 用户登陆
     * @param customer 用户对象
     * @return 结果
     */
    CustomerInfo userLogin(CustomerInfo customer);

    /**
     * 根据用户ID获取用户对象
     * @param id 用户id
     * @return 用户对象
     */
    CustomerInfo getCustomerById(@Param("id") String id);
}
