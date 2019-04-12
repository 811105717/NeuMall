package com.neusoft.mall.entity;


import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @ClassName: OrderDetail
 * @Description:F小组
 * @Author: zhangqiang
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
}

