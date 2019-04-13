package com.neusoft.mall.ordercenter.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.common.entity.PageVo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.OrderDetailInfo;
import com.neusoft.mall.entity.OrderInfo;
import com.neusoft.mall.entity.OrderQueryVo;
import com.neusoft.mall.ordercenter.mapper.OrderMapper;
import com.neusoft.mall.ordercenter.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: xiaobai
 * @Date: 2019/4/8 19:06
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * @Dept：大连东软信息学院
     * @Description： 获取订单列表
     * @Author：xiaobai
     * @Date: 2019/4/11
     * @Param：queryVo
     * @Return：com.neusoft.common.response.AppResponse
     */
    @Override
    public AppResponse getOrderList(OrderQueryVo queryVo) {
        //用户id不为空的时候
        if(null != queryVo.getCustomerId() && !"".equals(queryVo.getCustomerId())){
            //处理分页
            PageVo<OrderInfo>list = new PageVo<>();
            PageHelper.startPage(queryVo.getPageNum(),queryVo.getPageSize());
            List<OrderInfo> orderList = orderMapper.getOrderList(queryVo);
            list.setList(orderList);
            list.setTotalRecords((int)new PageInfo<>(orderList).getTotal());
            //获取数据成功！
            if(0<list.getTotalRecords()){
                return AppResponse.success("订单列表获取成功！",list);
            }else {
                return AppResponse.bizError("未找到订单！");
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
     * @Param：orderId
     * @Return：com.neusoft.common.response.AppResponse
     */
    @Override
    public AppResponse getOrderDetail(String orderId) {
        if (null != orderId && !"".equals(orderId)) {
            OrderInfo orderInfo = orderMapper.getOrderDetail(orderId);
            //为订单内商品加图
            List<OrderDetailInfo> commodityDetail = orderMapper.getOrderCommodityDetail(orderId);
            for (OrderDetailInfo od:commodityDetail){
                od.setCommodityFirstPicture(orderMapper.getGoodsFirstpictureAddress(od.getOrderId()));
            }
            orderInfo.setCommodityList(commodityDetail);
            return AppResponse.success("订单细节获取成功！",orderInfo);
        }else {
            return AppResponse.bizError("未知数据错误！");
        }
    }

    @Transactional
    @Override
    public AppResponse updateOrderStatus(List<String> orderList, String status) {
        if(null!=orderList && null!=status && !"".equals(status)){
            Integer res = orderMapper.updateOrderStatus(orderList,status);
            if (0 != res) {
                AppResponse.success("订单状态更新成功");
            }else {
                AppResponse.bizError("订单状态更新失败！返回结果0");
            }
        }else {
            return AppResponse.bizError("未知数据错误！");
        }
        //事务操作  必须最后有返回
        return AppResponse.bizError("未知错误！");
    }
}
