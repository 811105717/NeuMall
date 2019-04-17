package com.neusoft.mall.ordermanagement.mapper;

import com.neusoft.mall.entity.CommodityListInfo;
import com.neusoft.mall.entity.OrderQueryVo;
import com.neusoft.mall.entity.OrdermanageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: fwk
 * @Description:
 * @Date: Create in 14:40 2019/4/9
 */
@Mapper
public interface OrderManageMapper {
 /**
  * @Dept：大连东软信息学院
  * @Description： 获取订单详情
  * @Author：fwk
  * @Date: 2019/4/14
  */
 public OrdermanageInfo getOrderDetail(String orderId);
 /**
  * @Dept：大连东软信息学院
  * @Description： 获取商品列表
  * @Author：fwk
  * @Date: 2019/4/14
  */
 public List<CommodityListInfo> getCommodityListInfo(String orderId);
 /**
  * @Dept：大连东软信息学院
  * @Description： 修改订单状态
  * @Author：fwk
  * @Date: 2019/4/15
  */
 public int updateOrderStatus(OrdermanageInfo ordermanageInfo);
 /**
  * @Dept：大连东软信息学院
  * @Description： 获取订单
  * @Author：fwk
  * @Date: 2019/4/15
  */
 public List<OrdermanageInfo> getOrders(OrderQueryVo orderQueryVo);
}
