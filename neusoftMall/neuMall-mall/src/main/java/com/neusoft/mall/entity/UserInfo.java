package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 14:02
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@Data
public class UserInfo extends BaseEntity {
    private String customerId; //客户id
    private String customerNumber; //账号
    private String customerName; //客户姓名
    private String customerIsUsed;// 启用/禁用  0启用1禁用
}
