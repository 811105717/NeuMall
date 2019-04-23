package com.neusoft.mall.commodityCenter.controller;


import com.neusoft.common.entity.BasePageVo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.commodityCenter.service.commodityCenterSerivice;
import com.neusoft.mall.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: commodityCenterController
 * @Description:F小组
 * @Author: zhangqiang
 * @Date: 2019/4/9
 */
@Api("商品中心")
@Slf4j
@RestController
@RequestMapping("/front/commodityCenter")
public class commodityCenterController {
    @Autowired
    private commodityCenterSerivice commodityCenterSerivice;
    @ApiOperation("商品中心主界面查询")
    @RequestMapping(value = "getCommodityList",method = RequestMethod.GET)
    public AppResponse getCommodityList(CommodityInfo commodityInfo, BasePageVo basePageVo,String sortingTotalCount,String sortingRetailPrice){
        return commodityCenterSerivice.getCommodityList(commodityInfo,basePageVo,sortingTotalCount,sortingRetailPrice);
    }
    @ApiOperation("加入购物车")
    @RequestMapping(value = "addShoppingCart",method = RequestMethod.POST)
    public AppResponse addShoppingCart(CommodityInfo commodityInfo,  ShopInfo shopInfo,String tokenFront){
        return commodityCenterSerivice.addShoppingCart(commodityInfo,shopInfo,tokenFront);
    }
    @ApiOperation("同类商品推荐")
    @RequestMapping(value = "getCommodityCenterSimilar",method = RequestMethod.GET)
    public AppResponse getCommodityCenterSimilar(CommodityInfo commodityInfo){
        return commodityCenterSerivice.getCommodityCenterSimilar(commodityInfo);
    }
    @ApiOperation("商品详情")
    @RequestMapping(value = "getCommodityCenterDeatil",method = RequestMethod.GET)
    public AppResponse getCommodityCenterDeatil(CommodityInfo commodityInfo,CustomerInfo customerInfo){
        return commodityCenterSerivice.getCommodityCenterDeatil(commodityInfo,customerInfo);
    }
    @ApiOperation("交易记录")
    @RequestMapping(value = "getCommodityCenterTrading",method = RequestMethod.GET)
    public AppResponse getCommodityCenterTradin(CommodityInfo commodityInfo){
        return commodityCenterSerivice.getCommodityCenterTradin(commodityInfo);
    }
    @ApiOperation("立即购买")
    @RequestMapping(value = "getCommodityBuyNow",method = RequestMethod.GET)
    public AppResponse getCommodityBuyNow(CommodityInfo commodityInfo,String commodityNum,String tokenFront){
        return  commodityCenterSerivice.getCommodityBuyNow(commodityInfo,commodityNum,tokenFront);
    }
    @ApiOperation("添加收藏/取消收藏")
    @RequestMapping(value = "commodityCollection",method = RequestMethod.POST)
    public AppResponse commodityCollection(CollectInfo collectInfo, String collectFlag,String tokenFront){
       return  commodityCenterSerivice.commodityCollection(collectInfo,collectFlag,tokenFront);
    }
    @ApiOperation("提交订单")
    @RequestMapping(value = "addOrder",method = RequestMethod.POST)
    public AppResponse addOrder(OrderInfo orderInfo, List<OrderDetail> commodityList,String tokenFront){
        return  commodityCenterSerivice.addOrder(orderInfo,commodityList,tokenFront);
    }
    @ApiOperation("收藏列表")
    @RequestMapping(value = "commodityCollectionList",method = RequestMethod.POST)
    public AppResponse commodityCollectionList(CommodityInfo commodityInfo,String tokenFront){
        return commodityCenterSerivice.commodityCollectionList(commodityInfo,tokenFront);
    }
}

