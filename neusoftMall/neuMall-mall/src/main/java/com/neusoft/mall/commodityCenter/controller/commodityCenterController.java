package com.neusoft.mall.commodityCenter.controller;

import com.neusoft.common.entity.BasePageVo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.commodityCenter.service.commodityCenterSerivice;
import com.neusoft.mall.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
@CrossOrigin
public class commodityCenterController {
    @Autowired
    private commodityCenterSerivice commodityCenterSerivice;

    @RequestMapping(value = "getCommodityList", method = RequestMethod.GET)
    public AppResponse getCommodityList(CommodityInfo commodityInfo, BasePageVo basePageVo) {
        return commodityCenterSerivice.getCommodityList(commodityInfo, basePageVo);
    }

    @RequestMapping(value = "addShoppingCart", method = RequestMethod.POST)
    public AppResponse addShoppingCart(CommodityInfo commodityInfo, ShopInfo shopInfo, String tokenFront) {
        return commodityCenterSerivice.addShoppingCart(commodityInfo, shopInfo, tokenFront);
    }

    @RequestMapping(value = "getCommodityCenterSimilar", method = RequestMethod.GET)
    public AppResponse getCommodityCenterSimilar(CommodityInfo commodityInfo) {
        return commodityCenterSerivice.getCommodityCenterSimilar(commodityInfo);
    }

    @RequestMapping(value = "getCommodityCenterDeatil", method = RequestMethod.GET)
    public AppResponse getCommodityCenterDeatil(CommodityInfo commodityInfo, String tokenFront) {
        return commodityCenterSerivice.getCommodityCenterDeatil(commodityInfo, tokenFront);
    }

    @RequestMapping(value = "getCommodityCenterTrading", method = RequestMethod.GET)
    public AppResponse getCommodityCenterTradin(CommodityInfo commodityInfo) {
        return commodityCenterSerivice.getCommodityCenterTradin(commodityInfo);
    };

    @RequestMapping(value = "getCommodityBuyNow", method = RequestMethod.POST)
    public AppResponse getCommodityBuyNow(@RequestBody GetCommodityVo getCommodityVo ) {
        System.out.println(getCommodityVo);
        return commodityCenterSerivice.getCommodityBuyNow(getCommodityVo.getCommodityList(), getCommodityVo.getTokenFront());
    }

    @RequestMapping(value = "commodityCollection", method = RequestMethod.POST)
    public AppResponse commodityCollection(@RequestBody CollectInfoVO collectInfoVO) {
        return commodityCenterSerivice.commodityCollection(collectInfoVO);
    }

    @RequestMapping(value = "addOrder", method = RequestMethod.POST)
    public AppResponse addOrder(@RequestBody OrderInfo orderInfo, String tokenFront) {
        return commodityCenterSerivice.addOrder(orderInfo, tokenFront);
    }

    @RequestMapping(value = "commodityCollectionList", method = RequestMethod.POST)
    public AppResponse commodityCollectionList(CollectList collectList, String tokenFront) {
        return commodityCenterSerivice.commodityCollectionList(collectList, tokenFront);
    }
}

