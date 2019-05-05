package com.neusoft.mall.shoppingCart.mapper;

import com.neusoft.mall.entity.ShopVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: ShoppingCart
 * @Description:
 * @Author: Hiccup
 * @Date: 2019/4/18
 */

@Mapper
public interface ShoppingCartMapper {
    List<ShopVo> findShopAll(@Param("customerId") String customerId);
    int deleteShoppingCart(@Param("customerId") String customerId, @Param("shopId") String shopId);
}
