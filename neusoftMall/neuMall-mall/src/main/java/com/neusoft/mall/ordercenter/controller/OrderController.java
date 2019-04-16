package com.neusoft.mall.ordercenter.controller;

import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.OrderQueryVo;
import com.neusoft.mall.entity.StateUpdateVo;
import com.neusoft.mall.ordercenter.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: xiaobai
 * @Date: 2019/4/8 17:49
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping(value = "/front/orderCenter")
@Api("订单中心API")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * @Dept：大连东软信息学院
     * @Description： 获取订单列表
     * @Author：xiaobai
     * @Date: 2019/4/11
     * @Param：queryVo 包装对象 页数 大小 用户id
     * @Return：com.neusoft.common.response.AppResponse
     */
    @ApiOperation("获取用户所有订单")
    @GetMapping(value="getOrderList")
    public AppResponse getOrderList(OrderQueryVo queryVo){
        return orderService.getOrderList(queryVo);
    }
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取订单细节（包括商品）
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：orderId 订单号
     * @Return：com.neusoft.common.response.AppResponse
     */
    @ApiOperation("获取订单详细信息")
    @GetMapping(value = "getOrderDetail")
    public AppResponse getOrderDetail(String orderId){
        return orderService.getOrderDetail(orderId);
    }
    /**
     * @Dept：大连东软信息学院
     * @Description： 更新订单状态
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：stateUpdateVo 包装类  订单号列表 状态码
     * @Return：com.neusoft.common.response.AppResponse
     */
    @ApiOperation("更新订单状态 已签收 撤销")
    @PutMapping(value = "updateOrderStatus")
    public AppResponse updateOrderStatus(@RequestBody StateUpdateVo stateUpdateVo){
        return orderService.updateOrderStatus(stateUpdateVo.getOrderNumberList(),stateUpdateVo.getOrderState());
    }

}
