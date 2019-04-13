package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Author: xiaobai
 * @Date: 2019/4/11 21:49
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @description ：用来查询商品明细的entity
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
    private String commodityFirstPicture;//商品首图

}
