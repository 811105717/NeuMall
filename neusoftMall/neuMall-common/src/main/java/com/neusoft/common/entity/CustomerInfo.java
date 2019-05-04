package com.neusoft.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 14:02
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Description 实体类 对应用户表
 * @Version 1.0
 */
@SuppressWarnings("ALL")
@Data
public class CustomerInfo extends BaseEntity implements Serializable {
    /**
     * 客户ID
     */
    private String customerId;
    /**
     * 账号
     */
    private String customerNumber;
    /**
     * 密码
     */
    private String customerPassword;
    /**
     * 新密码 用于密码修改
     */
    private String customerNewPassword;
    /**
     * 客户姓名
     */
    private String customerName;
    /**
     * 启用/禁用  0启用1禁用
     */
    private String customerIsUsed;
    /**
     * 前台用户token
     */
    private String tokenFront;
    /**
     * 后台用户token
     */
    private String tokenBackend;

}
