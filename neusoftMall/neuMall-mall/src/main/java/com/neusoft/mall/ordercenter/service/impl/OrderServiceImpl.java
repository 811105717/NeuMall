package com.neusoft.mall.ordercenter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.common.entity.CustomerInfo;
import com.neusoft.common.entity.PageVo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.OrderDetailInfo;
import com.neusoft.mall.entity.OrderInfo;
import com.neusoft.mall.entity.OrderQueryVo;
import com.neusoft.mall.ordercenter.mapper.OrderMapper;
import com.neusoft.mall.ordercenter.service.OrderService;
import com.neusoft.mall.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: xiaobai
 * @Date: 2019/4/8 19:06
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院 1
 * @Version 1.0
 */
@SuppressWarnings("ALL")
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RedisUtil<CustomerInfo> redisUtil;

    /**
     * @Dept：大连东软信息学院
     * @Description： 获取订单列表
     * @Author：xiaobai
     * @Date: 2019/4/11
     * @Param：queryVo 包装类 页码 页大小 用户
     * @Return：com.neusoft.common.response.AppResponse
     */
    @Override
    public AppResponse getOrderList(OrderQueryVo queryVo) {
        if(null == queryVo.getTokenFront()){
            return AppResponse.bizError("token失效");
        }
        //根据token 获取customer对象，并且得到customerId 赋值给queryVo
        CustomerInfo currCustomer = redisUtil.getData(queryVo.getTokenFront());
        queryVo.setCustomerId(currCustomer.getCustomerId());
        if(null != queryVo.getCustomerId() && !"".equals(queryVo.getCustomerId())){
            PageVo<OrderInfo>list = new PageVo<>();
            PageHelper.startPage(queryVo.getPageNum(),queryVo.getPageSize());
            List<OrderInfo> orderList = orderMapper.getOrderList(queryVo);
            //每一条订单对应多个商品
            for(OrderInfo o:orderList){
                List<OrderDetailInfo> orderDetailInfos = orderMapper.getOrderCommodityDetail(o.getOrderId());
                        o.setCommodityList(orderDetailInfos);
            }
            list.setList(orderList);
            list.setTotalRecords((int)new PageInfo<>(orderList).getTotal());
            if(0<list.getTotalRecords()){
                return AppResponse.success("订单列表获取成功！",list);
            }else {
                return AppResponse.notFound("未查询到数据！");
            }

        }else {
            return AppResponse.bizError("未知参数错误！");
        }
    }
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取订单详细信息
     * @Author：xiaobai
     * @Date: 2019/4/11
     * @Param：orderId 订单id
     * @Return：com.neusoft.common.response.AppResponse
     */
    @Override
    public AppResponse getOrderDetail(String orderId) {
        if (null != orderId && !"".equals(orderId)) {
            OrderInfo orderInfo = orderMapper.getOrderDetail(orderId);
            if(null == orderInfo){
                return AppResponse.notFound("未查询到该订单信息");
            }else {
                List<OrderDetailInfo> commodityDetail = orderMapper.getOrderCommodityDetail(orderId);
                if(0 == commodityDetail.size()){
                    return AppResponse.notFound("该订单不存在商品！");
                }else {
                    orderInfo.setCommodityList(commodityDetail);
                    return AppResponse.success("订单细节获取成功！",orderInfo);
                }
            }
        }else {
            return AppResponse.bizError("未知数据错误！");
        }
    }
    /**
     * @Dept：大连东软信息学院
     * @Description： 更新订单状态
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：orderList 订单号列表
        status 订单状态码
     * @Return：com.neusoft.common.response.AppResponse
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public AppResponse updateOrderStatus(List<String> orderList, String status) {
        if(null!= orderList && null!=status && !"".equals(status)){
            Integer res = orderMapper.updateOrderStatus(orderList,status);
            if (0 != res) {
                return AppResponse.success("订单状态更新成功");
            }else {
                return AppResponse.notFound("未找到相关订单");
            }
        }else {
            return AppResponse.bizError("未知数据错误！");
        }
    }
}
