package com.neusoft.mall.ordercenter.service;

import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.OrderQueryVo;

import java.util.List;

/**
 * @Author: xiaobai
 * @Date: 2019/4/8 19:05
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@SuppressWarnings("ALL")
public interface OrderService {

    /**
     * 获取订单列表
     * @param queryVo 查询条件
     * @return 结果
     */
    AppResponse getOrderList(OrderQueryVo queryVo);

    /**
     * 获取订单详细信息
     * @param orderId 订单ID
     * @return 结果
     */
    AppResponse getOrderDetail(String orderId);

    /**
     * 更新订单状态
     * @param orderList 订单列表
     * @param status 状态
     * @return 更新结果
     */
    AppResponse updateOrderStatus(List<String> orderList, String status);

}
