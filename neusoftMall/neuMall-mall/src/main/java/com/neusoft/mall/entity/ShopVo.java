package com.neusoft.mall.entity;


import lombok.Data;

/**
 * @ClassName: ShoppingCartController
 * @Description: 获取购物车信息
 * @Author: Hiccup
 * @Date: 2019/4/18
 */
@Data
public class ShopVo{
    private  String  shopId;
    private  String commodityId;
    private  String commodityCode;
    private  String pictureAddress;
    private  String commodityName;
    private  String commodityRetailPrice;
    private  String commodityNum;

}
