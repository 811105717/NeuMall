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
}
