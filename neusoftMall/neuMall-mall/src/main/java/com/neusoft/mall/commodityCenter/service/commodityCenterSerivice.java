package com.neusoft.mall.commodityCenter.service;

import com.neusoft.common.entity.BasePageVo;
import com.neusoft.common.entity.CustomerInfo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.*;

import java.util.List;

/**
 * @ClassName: commodityCenterSerivice
 * @Description:F小组
 * @Author: zhangqiang
 * @Date: 2019/4/9
 */
public interface commodityCenterSerivice {
    AppResponse getCommodityList(CommodityInfo commodityInfo, BasePageVo basePageVo, String sortingTotalCount, String sortingRetailPrice);//商品中心主界面查询

    AppResponse addShoppingCart(CommodityInfo commodityInfo, ShopInfo shopInfo, String tokenFront);//加入购物车

    AppResponse getCommodityCenterDeatil(CommodityInfo commodityInfo, String tokenFront);//商品详情

    AppResponse getCommodityCenterSimilar(CommodityInfo commodityInfo);//同类商品推荐

    AppResponse getCommodityCenterTradin(CommodityInfo commodityInfo);//交易记录

    AppResponse getCommodityBuyNow(CommodityInfo commodityInfo, TradinInfo tradinInfo, String tokenFront);//立即购买

    AppResponse commodityCollection(CollectInfo collectInfo, String collectFlag, String tokenFront);//添加收藏/取消收藏

    AppResponse addOrder(OrderInfo orderInfo, String tokenFront);//提交订单

    AppResponse commodityCollectionList(CommodityInfo commodityInfo, String tokenFront);
}
