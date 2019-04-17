package com.neusoft.mall.ordermanagement.controller;

import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.CommodityListInfo;
import com.neusoft.mall.entity.OrderNumberListInfo;
import com.neusoft.mall.entity.OrderQueryVo;
import com.neusoft.mall.entity.OrdermanageInfo;
import com.neusoft.mall.ordermanagement.service.OrderManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @Author: linmeng
 * @Description:
 * @Date: Create in 14:38 2019/4/9
 */
@Slf4j
@RestController
@RequestMapping(value = "backend")
public class OrderManageController {
    @Autowired
    OrderManageService orderManageService;

    /**
     * @Dept：大连东软信息学院
     * @Description： 获取订单详情
     * @Author：fanwenkai
     * @Date: 2019/4/15
     */
    @RequestMapping(value = "order/getOrderDetail",method = RequestMethod.GET)
    public AppResponse getCustomerDetail(@PathParam("orderId") String orderId) throws Exception{
        System.out.print(orderId);
        OrdermanageInfo ordermanageInfo = null;
        List<CommodityListInfo> commodityInfoList=null;
        try {
            ordermanageInfo =orderManageService.getOrderDetail(orderId);
            commodityInfoList=orderManageService.getCommodityListInfo(orderId);
            ordermanageInfo.setCommodityList(commodityInfoList);
        } catch (Exception e) {
            log.error("订单查询错误", e);
            throw new Exception("查询错误，请重试");
        }
        if (ordermanageInfo == null) {
            return AppResponse.notFound("无查询结果");
        }
        return AppResponse.success("查询成功", ordermanageInfo);
    }
    /**
     * @Dept：大连东软信息学院
     * @Description： 订单发货（修改订单状态）
     * @Author：fanwenkai
     * @Date: 2019/4/15
     */
    @PutMapping(value = "order/updateOrderStatus")
    public AppResponse updateAccount(@RequestBody OrderNumberListInfo orderNumberListInfo) throws Exception {
        System.out.print(orderNumberListInfo);
        String user="stt1";//修改订单的用户名
        orderNumberListInfo.setLastModifiedBy(user);
        try {
            AppResponse appResponse = orderManageService.updateOrderStatus(orderNumberListInfo);
            return appResponse;
        } catch (Exception e) {
            log.error("订单修改失败", e);
            throw new Exception("用户修改失败，请重试");
        }
    }
    /**
     * @Dept：大连东软信息学院
     * @Description： 查询订单
     * @Author：fanwenkai
     * @Date: 2019/4/15
     */
    @GetMapping(value = "order/getOrders")
    public AppResponse getOrderList(OrderQueryVo queryVo){
        System.out.print(queryVo.getPageNum());
        return orderManageService.getOrders(queryVo);
    }

}
