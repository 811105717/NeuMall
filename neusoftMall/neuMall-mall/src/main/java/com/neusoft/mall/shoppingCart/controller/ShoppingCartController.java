package com.neusoft.mall.shoppingCart.controller;

import com.neusoft.common.entity.CustomerInfo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.ShopVo;
import com.neusoft.mall.shoppingCart.service.ShoppingCartService;
import com.neusoft.mall.util.RedisUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @ClassName: ShoppingCartController
 * @Description: 购物车
 * @Author: Hiccup
 * @Date: 2019/4/18
 */
@RestController
@Slf4j
@RequestMapping("front/shoppingCart")
@Api
@CrossOrigin
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private RedisUtil redisUtil;



    /**
     * @ClassName: ShoppingCartController
     * @Description: 获取购物车信息
     * @Author: Hiccup
     * @Date: 2019/4/18
     */
    @RequestMapping(value = "getShoppingCartList",method = RequestMethod.GET )
    public AppResponse getShoppingCartList(CustomerInfo customer){
        CustomerInfo  customerinfo= (CustomerInfo) redisUtil.getData(customer.getTokenFront());
        if ( customerinfo == null ){
            return AppResponse.bizError("token失效");
        }
        String customerId = customerinfo.getCustomerId();
        System.out.println("customerId:"+customerId);
        List<ShopVo> shop = shoppingCartService.findShopAll(customerId);
        if(shop.size()>0){
                return AppResponse.success("请求成功",shop);
        }
        else {
            return AppResponse.notFound("notfind"+shop);
        }
    }

    /**
     * @ClassName: ShoppingCartController
     * @Description: 将商品移出购物车
     * @Author: Hiccup
     * @Date: 2019/4/18
     */
    @DeleteMapping("deleteShoppingCart")
    public AppResponse deleteShoppingCart(CustomerInfo customer,  String shopId){

        System.out.println(customer + " " + shopId);
        CustomerInfo  customerinfo= (CustomerInfo) redisUtil.getData(customer.getTokenFront());
        if ( customerinfo == null ){
            return AppResponse.bizError("token失效");
        }
        String customerId = customerinfo.getCustomerId();
        int a = shoppingCartService.deleteShoppingCart(customerId ,shopId);
        System.out.println("a"+a);
        if(a==0){
            return AppResponse.bizError("未找到该购物车");
        }else if(a==1){
            return AppResponse.success("删除成功");
        }
        return AppResponse.bizError("未知错误");
    }


}
