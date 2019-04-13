package com.neusoft.mall.ordercenter.controller;

import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.OrderQueryVo;
import com.neusoft.mall.ordercenter.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xiaobai
 * @Date: 2019/4/8 17:49
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/front/orderCenter")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * @Dept：大连东软信息学院
     * @Description： 获取订单列表
     * @Author：xiaobai
     * @Date: 2019/4/11
     * @Param：queryVo
     * @Return：com.neusoft.common.response.AppResponse
     */

    @GetMapping(value="getOrderList")
    public AppResponse getOrderList(OrderQueryVo queryVo){
        return orderService.getOrderList(queryVo);
    }

    @GetMapping(value = "getOrderDetail")
    public AppResponse getOrderDetail(String orderId){
        return orderService.getOrderDetail(orderId);
    }
    @PutMapping(value = "updateOrderStatus")
    public AppResponse updateOrderStatus(
            @RequestParam("orderNumberList") List<String> orderNumberList,
            @RequestParam("orderState") String orderState){
        return orderService.updateOrderStatus(orderNumberList,orderState);
    }

}
