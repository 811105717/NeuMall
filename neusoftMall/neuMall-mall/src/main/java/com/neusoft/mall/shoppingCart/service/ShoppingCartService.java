package com.neusoft.mall.shoppingCart.service;

import com.neusoft.mall.entity.ShopVo;

import java.util.List;

/**
 * @ClassName: ShoppingCartController
 * @Description:
 * @Author: Hiccup
 * @Date: 2019/4/18
 */
public interface ShoppingCartService {
    List<ShopVo> findShopAll(String customerId);
    int deleteShoppingCart(String customerId, String shopId);
}
