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
@Mapper
@Component
public interface OrderMapper {
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取订单列表
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：queryVo 含有页数的订单编号
     * @Return：java.util.List<com.neusoft.mall.entity.OrderInfo>
     */
    List<OrderInfo> getOrderList(OrderQueryVo queryVo);
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取订单详细信息
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：orderId 订单ID
     * @Return：com.neusoft.mall.entity.OrderInfo
     */
    OrderInfo getOrderDetail(@Param("orderId") String orderId);
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取订单内全部商品信息
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：orderId 订单ID
     * @Return：java.util.List<com.neusoft.mall.entity.OrderDetailInfo>
     */
    List<OrderDetailInfo> getOrderCommodityDetail(@Param("orderId") String orderId);
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取订单内商品的首图
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：commodityId 商品ID  可以从订单中明细中获得
     * @Return：java.lang.String
     */
    String getGoodsFirstpictureAddress(@Param("commodityId") String commodityId);

    Integer updateOrderStatus(@Param("orderList")List<String> orderList,@Param("status") String status);
}
