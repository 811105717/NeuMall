package com.neusoft.mall.entity;

import com.neusoft.common.entity.BasePageVo;
import lombok.Data;

/**
 * @Author: xiaobai
 * @Date: 2019/4/11 19:01
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Description:
 * @Version 1.0
 */
@Data
public class OrderQueryVo extends BasePageVo {
    private String orderNumber; //订单信息
    private String orderDateStart;//订单开始日期
    private String orderDateEnd; //订单结束日期
    private String orderState; //订单状态
    private String customerId; //下单人ID
}