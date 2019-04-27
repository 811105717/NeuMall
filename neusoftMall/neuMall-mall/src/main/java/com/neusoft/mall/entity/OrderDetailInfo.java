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
    /**
     * 订单明细ID
     */
    private String orderDetailId;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 商品ID
     */
    private String commodityId;
    /**
     * 单价
     */
    private String commodityPrice;
    /**
     * 数量
     */
    private String commodityNum;
    /**
     * 总价
     */
    private String commodityTotalPrice;
    /**
     * 商品编号
     */
    private String commodityCode;
    /**
     * 商品名称
     */
    private String commodityName;
    /**
     * 商品首图
     */
    private String pictureAddress;
}
