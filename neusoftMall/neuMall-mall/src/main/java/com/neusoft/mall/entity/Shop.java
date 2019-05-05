package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @ClassName: ShoppingCartController
 * @Description: 获取购物车信息
 * @Author: Hiccup
 * @Date: 2019/4/18
 */
@Data
public class Shop extends BaseEntity {
    private  String  shopId;
    private  String commodityId;
    private  String shopNumber;
    private  String customerId;
}
