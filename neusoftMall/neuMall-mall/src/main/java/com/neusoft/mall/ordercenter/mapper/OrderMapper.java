package com.neusoft.mall.ordercenter.mapper;

import com.neusoft.mall.entity.OrderDetailInfo;
import com.neusoft.mall.entity.OrderInfo;
import com.neusoft.mall.entity.OrderQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: xiaobai
 * @Date: 2019/4/8 19:07
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@SuppressWarnings("ALL")
@Mapper
@Component
public interface OrderMapper {

    /**
     * 获取订单列表
     * @param queryVo 查询条件
     * @return 结果
     */
    List<OrderInfo> getOrderList(OrderQueryVo queryVo);

    /**
     * 获取订单详细信息
     * @param orderId 订单ID
     * @return 结果
     */
    OrderInfo getOrderDetail(@Param("orderId") String orderId);

    /**
     * 获取订单中商品的信息
     * @param orderId 订单ID
     * @return 结果
     */
    List<OrderDetailInfo> getOrderCommodityDetail(@Param("orderId") String orderId);

    /**
     * 更新订单状态
     * @param orderList 订单列表
     * @param status 状态码
     * @return
     */
    Integer updateOrderStatus(@Param("orderList")List<String> orderList,@Param("status") String status);
}
