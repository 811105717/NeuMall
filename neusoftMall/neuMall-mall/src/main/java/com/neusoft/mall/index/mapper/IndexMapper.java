package com.neusoft.mall.index.mapper;

import com.neusoft.mall.entity.CateGoryInfo;
import com.neusoft.mall.entity.CommodityInfo;

import com.neusoft.mall.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: xiaobai
 * @Date: 2019/4/8 17:47
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */

@SuppressWarnings("ALL")
@Mapper
@Component
public interface IndexMapper {
    /**
     * 首页获取推荐商品
     * @param recommend 是否推荐
     * @return 返回推荐商品
     */
    List<CommodityInfo> getCommodityList(@Param("recommend") String recommend);

    /**
     * 获取用户所有的订单
     * @param customerId 用户ID
     * @return 订单列表
     */
    List<OrderInfo> getUserOrderList(@Param("customerId")String customerId);

    /**
     * 根据订单ID获取该订单中所有的商品
     * @param orderId 订单ID
     * @return 该订单中所有的商品
     */
    List<CommodityInfo> getCommodityByOrderId(@Param("orderId") String orderId);

    /**
     * 根据父分类ID获取子分类列表 若父分类ID为 0 则返回一级分类
     * @param categoryParentId 分类ID
     * @return 子分类列表
     */
    List<CateGoryInfo> getCategoryByParent(@Param("categoryParentId") String categoryParentId);

    /**
     * 获取一级分类（父分类）
     * @return 一级分类列表
     */
    List<CateGoryInfo> getParentCategory();
}
