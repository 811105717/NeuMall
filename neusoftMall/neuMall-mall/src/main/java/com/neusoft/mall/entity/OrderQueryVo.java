package com.neusoft.mall.entity;

import com.neusoft.common.entity.BasePageVo;
import lombok.Data;

/**
 * @Author: xiaobai
 * @Date: 2019/4/11 19:01
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Description: 用于辅助查询订单的类 （分页）
 * @Version 1.0
 */
@Data
public class OrderQueryVo extends BasePageVo {
    private String orderNumber; //订单信息
    private String orderDateStart;//订单开始日期
    private String orderDateEnd; //订单结束日期
    private String orderState; //订单状态
    private String customerId; //下单人ID
    private String tokenFront;//token

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDateStart() {
        return orderDateStart;
    }

    public void setOrderDateStart(String orderDateStart) {
        this.orderDateStart = orderDateStart;
    }

    public String getOrderDateEnd() {
        return orderDateEnd;
    }

    public void setOrderDateEnd(String orderDateEnd) {
        this.orderDateEnd = orderDateEnd;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTokenFront() {
        return tokenFront;
    }

    public void setTokenFront(String tokenFront) {
        this.tokenFront = tokenFront;
    }
}
