package com.neusoft.mall.index.mapper;

import com.neusoft.mall.entity.CateGoryInfo;
import com.neusoft.mall.entity.CommodityInfo;

import com.neusoft.mall.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: xiaobai
 * @Date: 2019/4/8 17:47
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@Mapper
@Component
public interface IndexMapper {
    //推荐列表
    List<CommodityInfo> getCommodityList(@Param("recommend") String recommend);
    //查询用户全部订单
    List<OrderInfo> getUserOrderList(@Param("customerId")String customerId);
    //根据订单号查询全部商品细节
    CommodityInfo getCommodityByOrderId(@Param("orderId") String orderId);
    List<CateGoryInfo> getCategoryByParent(@Param("categoryParentId") String categoryParentId);
}
