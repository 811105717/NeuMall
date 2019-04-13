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
public interface OrderService {

    AppResponse getOrderList(OrderQueryVo queryVo);
    AppResponse getOrderDetail(String orderId);
    AppResponse updateOrderStatus(List<String> orderList, String status);

}
