package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
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

}
