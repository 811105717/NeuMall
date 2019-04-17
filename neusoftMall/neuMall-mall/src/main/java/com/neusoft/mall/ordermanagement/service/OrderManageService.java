package com.neusoft.mall.ordermanagement.service;

import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.CommodityListInfo;
import com.neusoft.mall.entity.OrderNumberListInfo;
import com.neusoft.mall.entity.OrderQueryVo;
import com.neusoft.mall.entity.OrdermanageInfo;

import java.util.List;

/**
 * @Author: fanwenkai
 * @Description:
 * @Date: Create in 14:41 2019/4/9
 */
public interface OrderManageService {
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取订单详情
     * @Author：fanwenkai
     * @Date: 2019/4/15
     */
OrdermanageInfo getOrderDetail(String orderId);
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取商品列表
     * @Author：fanwenkai
     * @Date: 2019/4/15

     */
List<CommodityListInfo> getCommodityListInfo(String orderId);
    /**
     * @Dept：大连东软信息学院
     * @Description： 订单发货（修改订单状态）
     * @Author：fanwenkai
     * @Date: 2019/4/15

     */
AppResponse updateOrderStatus(OrderNumberListInfo orderNumberList);
/**
* @Dept：大连东软信息学院
* @Description： 查询订单
* @Author：fanwenkai
* @Date: 2019/4/15
*/
AppResponse getOrders(OrderQueryVo queryVo);
}
