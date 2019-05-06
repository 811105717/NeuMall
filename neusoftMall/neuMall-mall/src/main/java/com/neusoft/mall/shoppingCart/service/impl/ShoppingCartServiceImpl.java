package com.neusoft.mall.shoppingCart.service.impl;

import com.neusoft.mall.shoppingCart.mapper.ShoppingCartMapper;
import com.neusoft.mall.entity.ShopVo;
import com.neusoft.mall.shoppingCart.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: ShoppingCartController
 * @Description:
 * @Author: Hiccup
 * @Date: 2019/4/18
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Resource
    ShoppingCartMapper shoppingCartMapper;

    @Override
    public List<ShopVo> findShopAll(String customerId) {
        return shoppingCartMapper.findShopAll(customerId);
    }

    @Override
    public int deleteShoppingCart(String customerId,String shopId) {
        return shoppingCartMapper.deleteShoppingCart(customerId ,shopId);
    }
}
