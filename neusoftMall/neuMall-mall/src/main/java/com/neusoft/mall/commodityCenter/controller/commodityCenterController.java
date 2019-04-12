package com.neusoft.mall.commodityCenter.controller;


import com.neusoft.common.entity.BasePageVo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.commodityCenter.service.commodityCenterSerivice;
import com.neusoft.mall.entity.CommodityInfo;
import com.neusoft.mall.entity.OrderDetail;
import com.neusoft.mall.entity.OrderInfo;
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
@Slf4j
@RestController
@RequestMapping("/front/commodityCenter")
public class commodityCenterController {

    @Autowired
    private commodityCenterSerivice commodityCenterSerivice;

    @RequestMapping(value = "getCommodityList",method = RequestMethod.GET)
    public AppResponse getCommodityList(CommodityInfo commodityInfo, BasePageVo basePageVo,String sortingTotalCount,String sortingRetailPrice){
        return commodityCenterSerivice.getCommodityList(commodityInfo,basePageVo,sortingTotalCount,sortingRetailPrice);
    }
    @RequestMapping(value = "getCommodityCenterSimilar",method = RequestMethod.GET)
    public AppResponse getCommodityCenterSimilar(CommodityInfo commodityInfo){
        return commodityCenterSerivice.getCommodityCenterSimilar(commodityInfo);
    }
    @RequestMapping(value = "getCommodityCenterDeatil",method = RequestMethod.GET)
    public AppResponse getCommodityCenterDeatil(CommodityInfo commodityInfo){
        return commodityCenterSerivice.getCommodityCenterDeatil(commodityInfo);
    }
    @RequestMapping(value = "getCommodityCenterTradin",method = RequestMethod.GET)
    public AppResponse getCommodityCenterTradin(CommodityInfo commodityInfo){
        return commodityCenterSerivice.getCommodityCenterTradin(commodityInfo);
    }
    @RequestMapping(value = "getCommodityBuyNow",method = RequestMethod.GET)
    public AppResponse getCommodityBuyNow(CommodityInfo commodityInfo,String commodityNum){
        return  commodityCenterSerivice.getCommodityBuyNow(commodityInfo,commodityNum);
    }
    @RequestMapping(value = "addOrder",method = RequestMethod.POST)
    public AppResponse addOrder(OrderInfo orderInfo, List<OrderDetail> commodityList){
        return  commodityCenterSerivice.addOrder(orderInfo,commodityList);
    }
}

