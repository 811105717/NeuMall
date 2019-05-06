package com.neusoft.mall.commodityCenter.mapper;

import com.neusoft.mall.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: commodityCenterMapper
 * @Description:F小组
 * @Author: zhangqiang
 * @Date: 2019/4/9
 */
@Mapper
@Component
public interface commodityCenterMapper {
    List<CommodityInfo> getCommodityList(CommodityInfo commodityInfo);

    Boolean addShoppingCart(@Param("shopId") String shopId, @Param("commodityId") String commodityId, @Param("shopNumber") String shopNumber, @Param("customerId") String customerId);//加入购物车

    Deatilinfo getCommodityCenterDeatil(@Param("commodityId") String commodityId);//商品详情

    List<CommodityInfo> getCommodityCenterSimilar(@Param("categoryFirst") String categoryFirst);//同类商品推荐

    List<TradinInfo> getCommodityCenterTradin(@Param("commodityId") String commodityId);//交易记录

    TradinInfo getCommodityBuyNow(@Param("commodityId") String commodityId);//立即购买

    Boolean commodityCollection(CollectInfo collectInfo);//添加收藏/取消收藏

    CollectInfo commodityCollectionForId(CollectInfo collectInfo);

    Boolean commodityCollectionForDelete(CollectInfo collectInfo);//添加收藏/取消收藏

    Boolean addOrder(@Param("orderId") String orderId, @Param("orderNumber") String orderNumber, @Param("orderPrice") String orderPrice, @Param("customerId") String customerId, @Param("orderAddress") String orderAddress, @Param("receiveTel") String receiveTel, @Param("receiveContact") String receiveContact, @Param("orderRemark") String orderRemark);//提交订单

    Boolean addOrderDetail(@Param("orderDetailId") String orderDetailId, @Param("orderId") String orderId, @Param("commodityId") String commodityId, @Param("commodityPrice") String commodityPrice, @Param("commodityNum") String commodityNum, @Param("commodityTotalPrice") String commodityTotalPrice);//提交订单

    String addOrderDetailForPrice(@Param("commodityId") String commodityId);//提交订单

    List<CollectList> commodityCollectionList(@Param("customerId") String customerId);//收藏列表

    List<CollectList> commodityCollectionListForSearch(CollectList collectList);

}
