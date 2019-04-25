package com.neusoft.mall.entity;

import com.neusoft.common.entity.BasePageVo;
import lombok.Data;

/**
 * @Author: fwk
 * @Description:
 * @Date: Create in 20:14 2019/4/15
 */
@Data
public class CustomerInfoVo extends BasePageVo {
    private String customerId; //客户id
    private String customerNumber; //账号
    private String customerPassword; //密码
    private String customerName; //客户姓名
    private String customerIsUsed;// 启用/禁用  0启用1禁用
    private int version;//版本号

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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
