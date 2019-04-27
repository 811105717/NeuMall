package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 17:50
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Description 实体类 对应订单表
 * @Version 1.0
 */
@Data
public class OrderInfo extends BaseEntity {
    /**
     * 订单ID
     */
    private String orderId;
    /**
     *订单编号
     */
    private String orderNumber;
    /**
     *订单金额
     */
    private String orderPrice;
    /**
     *下单人
     */
    private String customerId;
    /**
     *下单人姓名
     */
    private String customerName;
    /**
     *订单状态 1待发货 2已发货 3已完成4已撤销
     */
    private String orderState;
    /**
     *订单日期
     */
    private String orderDate;
    /**
     *收货地址
     */
    private String orderAddress;
    /**
     *联系方式
     */
    private String receiveTel;
    /**
     *收件人
     */
    private String receiveContact;
    /**
     *发货留言
     */
    private String orderRemark;
    /**
     *订单明细
     */
    private List<OrderDetailInfo> commodityList;

}
