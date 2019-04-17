package com.neusoft.mall.ordermanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.common.entity.PageVo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.CommodityListInfo;
import com.neusoft.mall.entity.OrderNumberListInfo;
import com.neusoft.mall.entity.OrderQueryVo;
import com.neusoft.mall.entity.OrdermanageInfo;
import com.neusoft.mall.ordermanagement.mapper.OrderManageMapper;
import com.neusoft.mall.ordermanagement.service.OrderManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: linmeng
 * @Description:
 * @Date: Create in 14:42 2019/4/9
 */
@Service
public class OrderManageServiceImpl implements OrderManageService {
    @Resource
    OrderManageMapper orderManageMapper;

    /**
     * @Dept：大连东软信息学院
     * @Description： 获取订单详情
     * @Author：fanwenkai
     * @Date: 2019/4/15
     */
    @Override
    public OrdermanageInfo getOrderDetail(String orderId) {
     OrdermanageInfo ordermanageInfo =orderManageMapper.getOrderDetail(orderId);
     return ordermanageInfo;
    }
    /**
     * @Dept：大连东软信息学院
     * @Description： 商品列表
     * @Author：fanwenkai
     * @Date: 2019/4/15
     */
    @Override
    public List<CommodityListInfo> getCommodityListInfo(String orderId) {
        List<CommodityListInfo> commodityListInfos=orderManageMapper.getCommodityListInfo(orderId);
        return commodityListInfos;
    }
    /**
     * @Dept：大连东软信息学院
     * @Description： 订单发货(修改订单状态)
     * @Author：fanwenkai
     * @Date: 2019/4/15
     */
    @Override
    public AppResponse updateOrderStatus(OrderNumberListInfo orderNumberListInfo) {
        String orderState=orderNumberListInfo.getOrderState();
        String lastModifiedBy=orderNumberListInfo.getLastModifiedBy();
        for(String orderNumber:orderNumberListInfo.getOrderNumberList()){
         OrdermanageInfo ordermanageInfo =new OrdermanageInfo();
         ordermanageInfo.setOrderNumber(orderNumber);
         ordermanageInfo.setOrderState(orderState);
         ordermanageInfo.setLastModifiedBy(lastModifiedBy);
            int result=orderManageMapper.updateOrderStatus(ordermanageInfo);
            if (0 == result) {
                return AppResponse.bizError("修改失败，请重试！");
            }
        }
            return AppResponse.success("修改成功！");
    }
    /**
     * @Dept：大连东软信息学院
     * @Description： 查询订单
     * @Author：fanwenkai
     * @Date: 2019/4/15
     */
    @Override
    public AppResponse getOrders(OrderQueryVo orderQueryVo) {
            //处理分页
            PageVo<OrdermanageInfo> list = new PageVo<>();
            PageHelper.startPage(orderQueryVo.getPageNum(),orderQueryVo.getPageSize());
            List<OrdermanageInfo> orderList = orderManageMapper.getOrders(orderQueryVo);
            list.setList(orderList);
            list.setTotalRecords((int)new PageInfo<>(orderList).getTotal());
            //获取数据成功！
            if(0<list.getTotalRecords()){
                return AppResponse.success("订单获取成功！",list);
            }else {
                return AppResponse.notFound("未查询到数据！");
            }
        }
    }