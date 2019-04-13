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

@SuppressWarnings("ALL")
@Mapper
@Component
public interface IndexMapper {
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取推荐列表
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：recommend 是否推荐 （写死到是了这里）
     * @Return：java.util.List<com.neusoft.mall.entity.CommodityInfo>
     */
    List<CommodityInfo> getCommodityList(@Param("recommend") String recommend);
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取一个用户的全部订单
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：customerId 用户id
     * @Return：java.util.List<com.neusoft.mall.entity.OrderInfo>
     */
    List<OrderInfo> getUserOrderList(@Param("customerId")String customerId);
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取订单明细中的商品明细
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：orderId 订单id
     * @Return：com.neusoft.mall.entity.CommodityInfo
     */
    CommodityInfo getCommodityByOrderId(@Param("orderId") String orderId);
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取二级分类
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：categoryParentId 父分类
     * @Return：java.util.List<com.neusoft.mall.entity.CateGoryInfo>
     */
    List<CateGoryInfo> getCategoryByParent(@Param("categoryParentId") String categoryParentId);
}
