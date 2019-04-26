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
@Data
public class CustomerInfo extends BaseEntity implements Serializable {
    private String customerId; //客户id
    private String customerNumber; //账号
    private String customerPassword; //密码
    private String customerNewPassword;//新密码
    private String customerName; //客户姓名
    private String customerIsUsed;// 启用/禁用  0启用1禁用
    private String tokenFront; //用户token
    private String tokenBackend;
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerNewPassword() {
        return customerNewPassword;
    }

    public void setCustomerNewPassword(String customerNewPassword) {
        this.customerNewPassword = customerNewPassword;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerIsUsed() {
        return customerIsUsed;
    }

    public void setCustomerIsUsed(String customerIsUsed) {
        this.customerIsUsed = customerIsUsed;
    }

    public String getTokenFront() {
        return tokenFront;
    }

    public void setTokenFront(String tokenFront) {
        this.tokenFront = tokenFront;
    }
}
