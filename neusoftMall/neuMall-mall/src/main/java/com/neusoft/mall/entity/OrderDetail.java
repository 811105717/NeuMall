package com.neusoft.mall.entity;


import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @ClassName: OrderDetail
 * @Description:F小组
 * @Author: zhangqiang
 * @Description 实体类 对应订单细节
 * @Date: 2019/4/10
 */
@Data
public class OrderDetail extends BaseEntity{
    private String orderDetailId;//订单明细id
    private String orderId;//订单id
    private String commodityId;//商品id
    private String commodityPrice;//单价
    private String commodityNum;//数量
    private String commodityTotalPrice;//总价

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
}

