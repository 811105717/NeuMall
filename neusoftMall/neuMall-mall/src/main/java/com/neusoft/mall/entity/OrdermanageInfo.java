package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 17:50
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@Data
public class OrdermanageInfo extends BaseEntity {
    private String orderId;//订单ID
    private String orderNumber; //订单编号
    private String orderPrice; //订单金额
    private String customerId; //下单人
    private String orderState; //订单状态 1待发货 2已发货 3已完成4已撤销
    private String orderDate; //订单日期
    private String orderAddress; //收货地址
    private String receiveTel;//联系方式
    private String receiveContact; //收件人
    private String orderRemark; //发货留言
    private String tokenBackend;//后端token
    private List<CommodityListInfo> commodityList;//商品列表

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getReceiveTel() {
        return receiveTel;
    }

    public void setReceiveTel(String receiveTel) {
        this.receiveTel = receiveTel;
    }

    public String getReceiveContact() {
        return receiveContact;
    }

    public void setReceiveContact(String receiveContact) {
        this.receiveContact = receiveContact;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public List<CommodityListInfo> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<CommodityListInfo> commodityList) {
        this.commodityList = commodityList;
    }
}
