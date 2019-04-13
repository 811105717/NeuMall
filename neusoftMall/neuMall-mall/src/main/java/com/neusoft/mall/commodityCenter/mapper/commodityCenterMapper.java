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
public interface commodityCenterMapper {
   List<CommodityInfo> getCommodityList(@Param("categoryFirst") String categoryFirst, @Param("categorySecond") String categorySecond, @Param("start") int start, @Param("end") int end);//商品中心主界面查询
   Integer getCommodityListForTotalRecords(@Param("categoryFirst") String categoryFirst, @Param("categorySecond") String categorySecond);//商品中心主界面查询
   List<CommodityInfo> getCommodityListForName(@Param("commodityName") String commodityName,@Param("categoryFirst") String categoryFirst,@Param("categorySecond") String categorySecond,@Param("start") int start,@Param("end") int end);//商品中心主界面查询
   Integer getCommodityListForNameForTotalRecords(@Param("commodityName") String commodityName,@Param("categoryFirst") String categoryFirst,@Param("categorySecond") String categorySecond);//商品中心主界面查询
   List<CommodityInfo> getCommodityListForTotalCount1(@Param("categoryFirst") String categoryFirst,@Param("categorySecond") String categorySecond,@Param("start") int start,@Param("end") int end);//商品中心主界面查询
   List<CommodityInfo> getCommodityListForTotalCount2(@Param("categoryFirst") String categoryFirst,@Param("categorySecond") String categorySecond,@Param("start") int start,@Param("end") int end);//商品中心主界面查询
   List<CommodityInfo> getCommodityListForTetailPrice1(@Param("categoryFirst") String categoryFirst,@Param("categorySecond") String categorySecond,@Param("start") int start,@Param("end") int end);//商品中心主界面查询
   List<CommodityInfo> getCommodityListForTetailPrice2(@Param("categoryFirst") String categoryFirst,@Param("categorySecond") String categorySecond,@Param("start") int start,@Param("end") int end);//商品中心主界面查询
   Boolean addShoppingCart(@Param("commodityId") String commodityId,@Param("shopNumber")String shopNumber,@Param("customerId")String customerId);//加入购物车
   CommodityInfo getCommodityCenterDeatil(@Param("commodityId") String commodityId);//商品详情
   List<String> getCommodityCenterDeatilForCollect(@Param("commodityId") String commodityId);//商品详情
   List<String> getCommodityCenterDeatilForPic(@Param("commodityId") String commodityId);//商品详情
   List<CommodityInfo> getCommodityCenterSimilar(@Param("categoryFirst") String categoryFirst);//同类商品推荐
   List<String>  getCommodityCenterTradin(@Param("commodityId") String commodityId);//交易记录
   CommodityInfo  getCommodityBuyNow(@Param("commodityId") String commodityId);//立即购买
   String  getCommodityBuyNowForPrice(@Param("commodityId") String commodityId);//立即购买
   Boolean  commodityCollection(@Param("customerId")String customerId,@Param("commodityId")String commodityId);//添加收藏/取消收藏
   Boolean  commodityCollectionForDelete(@Param("customerId")String customerId,@Param("commodityId")String commodityId);//添加收藏/取消收藏
   Boolean  addOrder(@Param("orderNumber")String orderNumber,@Param("orderPrice")String orderPrice,@Param("customerId")String customerId,@Param("orderAddress")String orderAddress,@Param("receiveTel")String receiveTel,@Param("receiveContact")String receiveContact,@Param("orderRemark")String orderRemark);//提交订单
   Boolean  addOrderDetail(@Param("commodityId")String commodityId,@Param("commodityPrice")String commodityPrice,@Param("commodityNum")String commodityNum,@Param("commondityTotalPrice")String commondityTotalPrice);//提交订单
   String   addOrderDetailForPrice(@Param("commodityId")String commodityId);//提交订单
   List<String> commodityCollectionList(@Param("customerId")String customerId);//收藏列表
}
