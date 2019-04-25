package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Author: xiaobai
 * @Date: 2019/4/11 21:49
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @description ：实体类 对应商品明细与订单表链接
 * @Version 1.0
 */
@Data
public class OrderDetailInfo extends BaseEntity {
    private String orderDetailId; //订单明细id
    private String orderId; //订单id
    private String commodityId; //商品ID
    private String commodityPrice; //单价
    private String commodityNum; //数量
    private String commodityTotalPrice; //总价
    private String commodityCode;//商品编号
    private String commodityName;//商品名称
    private String pictureAddress;//商品首图

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(String commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommodityNum() {
        return commodityNum;
    }

    public void setCommodityNum(String commodityNum) {
        this.commodityNum = commodityNum;
    }

    public String getCommodityTotalPrice() {
        return commodityTotalPrice;
    }

    public void setCommodityTotalPrice(String commodityTotalPrice) {
        this.commodityTotalPrice = commodityTotalPrice;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }
}
