package com.neusoft.mall.commodityCenter.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.common.entity.BasePageVo;
import com.neusoft.common.entity.CustomerInfo;
import com.neusoft.common.entity.PageVo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.common.util.StringUtil;
import com.neusoft.common.util.UUIDUtil;
import com.neusoft.mall.commodityCenter.mapper.commodityCenterMapper;
import com.neusoft.mall.commodityCenter.service.commodityCenterSerivice;
import com.neusoft.mall.entity.*;
import com.neusoft.mall.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: commodityCenterSeriviceImpl
 * @Description:F小组
 * @Author: zhangqiang
 * @Date: 2019/4/9
 */
@Service
public class commodityCenterSeriviceImpl implements commodityCenterSerivice {
    @Autowired
    commodityCenterMapper commodityCenterMapper;

    @Transactional
    @Override
    public AppResponse getCommodityList(CommodityInfo commodityInfo, BasePageVo basePageVo, String sortingTotalCount, String sortingRetailPrice) {
        PageVo pageVo = new PageVo();
        if (sortingTotalCount.equals("1")){
            PageHelper.startPage(basePageVo.getPageNum(),basePageVo.getPageSize());
            List<CommodityInfo> commodityList=commodityCenterMapper.getCommodityListForTotalCount1(commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int)new PageInfo(commodityList).getTotal());
            if(pageVo!=null){
                return AppResponse.success("获取商品表成功",pageVo);
            }else{
                return AppResponse.notFound("获取商品表失败");
            }
       }else if (sortingTotalCount.equals("2")){
            PageHelper.startPage(basePageVo.getPageNum(),basePageVo.getPageSize());
            List<CommodityInfo> commodityList=commodityCenterMapper.getCommodityListForTotalCount2(commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int)new PageInfo(commodityList).getTotal());
            if(pageVo!=null){
                return AppResponse.success("获取商品表成功",pageVo);
            }else{
                return AppResponse.notFound("获取商品表失败");
            }
        }else if (sortingRetailPrice.equals("1")){
            PageHelper.startPage(basePageVo.getPageNum(),basePageVo.getPageSize());
            List<CommodityInfo> commodityList=commodityCenterMapper.getCommodityListForTetailPrice1(commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int)new PageInfo(commodityList).getTotal());
            if(pageVo!=null){
                return AppResponse.success("获取商品表成功",pageVo);
            }else{
                return AppResponse.notFound("获取商品表失败");
            }
        }else if (sortingRetailPrice.equals("2")){
            PageHelper.startPage(basePageVo.getPageNum(),basePageVo.getPageSize());
            List<CommodityInfo> commodityList=commodityCenterMapper.getCommodityListForTetailPrice2(commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int)new PageInfo(commodityList).getTotal());
            if(pageVo!=null){
                return AppResponse.success("获取商品表成功",pageVo);
            }else{
                return AppResponse.notFound("获取商品表失败");
            }
        }else if (commodityInfo.getCommodityName()!=null){
            PageHelper.startPage(basePageVo.getPageNum(),basePageVo.getPageSize());
            List<CommodityInfo> commodityList=commodityCenterMapper.getCommodityListForName(commodityInfo.getCommodityName(),commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int)new PageInfo(commodityList).getTotal());
            if(pageVo!=null){
                return AppResponse.success("获取商品表成功",pageVo);
            }else{
                return AppResponse.notFound("获取商品表失败");
            }
        }else if(commodityInfo.getCategoryFirst()!=null&&commodityInfo.getCategorySecond()!=null){
            PageHelper.startPage(basePageVo.getPageNum(),basePageVo.getPageSize());
            List<CommodityInfo> commodityList=commodityCenterMapper.getCommodityList(commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int)new PageInfo(commodityList).getTotal());
            if(pageVo!=null){
                return AppResponse.success("获取商品表成功",pageVo);
            }else{
                return AppResponse.notFound("获取商品表失败");
            }
        }else {
            PageHelper.startPage(basePageVo.getPageNum(),basePageVo.getPageSize());
            List<CommodityInfo> commodityList=commodityCenterMapper.getCommodityList0();
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int)new PageInfo(commodityList).getTotal());
            if(pageVo!=null){
                return AppResponse.success("获取商品表成功",pageVo);
            }else{
                return AppResponse.notFound("获取商品表失败");
            }
        }
    }
    @Transactional
    @Override
    public AppResponse addShoppingCart(CommodityInfo commodityInfo, ShopInfo shopInfo,String tokenFront) {
        RedisUtil redisUtil=new RedisUtil();
        if (redisUtil.getData(tokenFront)!=null){
            CustomerInfo customerInfo=(CustomerInfo)redisUtil.getData(tokenFront);
            String shopId= UUIDUtil.uuidStr();
            Boolean result=commodityCenterMapper.addShoppingCart(shopId,commodityInfo.getCommodityId(),shopInfo.getShop_number(),customerInfo.getCustomerId());
            if (result){
                return AppResponse.success("加入购物车成功");
            }else {
                return AppResponse.notFound("加入购物车失败");
            }

        }else{
            return null;
        }


    }
    @Transactional
    @Override
    public AppResponse getCommodityCenterDeatil(CommodityInfo commodityInfo,CustomerInfo customerInfo) {
        CommodityInfo deatil=commodityCenterMapper.getCommodityCenterDeatil(commodityInfo.getCommodityId());
        CommodityPic picturelist=commodityCenterMapper.getCommodityCenterDeatilForPic(commodityInfo.getCommodityId());
        CollectInfo result=commodityCenterMapper.getCommodityCenterDeatilForIsCollect(commodityInfo.getCommodityId(),customerInfo.getCustomerId());
        String isCollect;
        if (result!=null){
           isCollect="0";
        }else{
           isCollect="1";
        }
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("deatil",deatil);
        data.put("picturelist",picturelist);
        data.put("isCollect",isCollect);
        if(data!=null){
            return AppResponse.success("获取商品详情成功",data);
        }else{
            return AppResponse.notFound("获取商品详情失败");
        }

    }
    @Transactional
    @Override
    public AppResponse getCommodityCenterSimilar(CommodityInfo commodityInfo) {
        List<CommodityInfo> c=commodityCenterMapper.getCommodityCenterSimilar(commodityInfo.getCategoryFirst());
        Map<String,Object> data=new HashMap<>();
        data.put("similar",c);
        if(data!=null){
            return AppResponse.success("获取同类商品推荐成功",data);
        }else{
            return AppResponse.notFound("获取同类商品推荐失败");
        }
    }
    @Transactional
    @Override
    public AppResponse getCommodityCenterTradin(CommodityInfo commodityInfo) {
        List<TradinInfo> tradin=commodityCenterMapper.getCommodityCenterTradin(commodityInfo.getCommodityId());
        Map<String,Object> data=new HashMap<>();
        data.put("tradin",tradin);
        if(data!=null){
            return AppResponse.success("获取交易记录推荐成功",data);
        }else{
            return AppResponse.notFound("获取交易记录推荐失败");
        }
    }
    @Transactional
    @Override
    public AppResponse getCommodityBuyNow(CommodityInfo commodityInfo,String commodityNum,String tokenFront) {
        RedisUtil redisUtil=new RedisUtil();
        if (redisUtil.getData(tokenFront)!=null){
            CommodityInfo commodity=commodityCenterMapper.getCommodityBuyNow(commodityInfo.getCommodityId());
            String commodityPrice=commodity.getCommodityRetailPrice();
            int commodityTotalPriceInt=Integer.parseInt(commodityNum)*Integer.parseInt(commodityPrice);
            String commodityTotalPrice=String.valueOf(commodityTotalPriceInt);
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("commodity",commodity);
            data.put("commodityPrice",commodityPrice);
            data.put("commodityTotalPrice",commodityTotalPrice);
            if(data!=null){
                return AppResponse.success("立即购买成功",data);
            }else{
                return AppResponse.notFound("立即购买失败");
            }
        }else{
            return null;
        }

    }
    @Transactional
    @Override
    public AppResponse commodityCollection(CollectInfo collectInfo,String collectFlag,String tokenFront) {
        RedisUtil redisUtil=new RedisUtil();
        if (redisUtil.getData(tokenFront)!=null){
            if (collectFlag.equals("1")){
                String collectId=UUIDUtil.uuidStr();
                boolean result=commodityCenterMapper.commodityCollection(collectId,collectInfo.getCustomerId(),collectInfo.getCommodityId());
                if (result){
                    return AppResponse.success("添加收藏成功");
                }else {
                    return  AppResponse.notFound("添加收藏失败");
                }
            }else{
                String c=commodityCenterMapper.commodityCollectionForId(collectInfo.getCustomerId(),collectInfo.getCommodityId());
                boolean result=commodityCenterMapper.commodityCollectionForDelete(c);
                if (result){
                    return AppResponse.success("取消收藏成功");
                }else {
                    return  AppResponse.notFound("取消收藏失败");
                }
            }
        }else{
            return null;
        }

    }
    @Transactional
    @Override
    public AppResponse addOrder(OrderInfo orderInfo, List<OrderDetail> commodityList,String tokenFront) {
       RedisUtil redisUtil=new RedisUtil();
        if (redisUtil.getData(tokenFront)!=null){
           String orderId=UUIDUtil.uuidStr();
           Boolean result=commodityCenterMapper.addOrder(orderId,orderInfo.getOrderNumber(),orderInfo.getOrderPrice(),orderInfo.getCustomerId(),orderInfo.getOrderAddress(),orderInfo.getReceiveTel(),orderInfo.getReceiveContact(),orderInfo.getOrderRemark());
           String[] commodityPrice=new String[commodityList.size()];
           String[] commodityNum=new String[commodityList.size()];
           Boolean[] b=new Boolean[commodityList.size()];
           int orderPriceInt=0;
           int[] commodityTotalPriceInt=new int[commodityList.size()];
           for(int i=0;i<commodityList.size();i++){
               commodityPrice[i]=commodityCenterMapper.addOrderDetailForPrice(commodityList.get(i).getCommodityId());
               commodityNum[i]=commodityList.get(i).getCommodityNum();
               commodityTotalPriceInt[i]=Integer.parseInt(commodityPrice[i])*Integer.parseInt(commodityNum[i]);
               orderPriceInt=orderPriceInt+Integer.parseInt(commodityPrice[i])*Integer.parseInt(commodityNum[i]);
           }
           for(int i=0;i<commodityList.size();i++){
               String orderDetailId=UUIDUtil.uuidStr();
               commodityCenterMapper.addOrderDetail(orderDetailId,orderId,commodityList.get(i).getCommodityId(),commodityPrice[i],commodityNum[i],String.valueOf(commodityTotalPriceInt[i]));
           }
           String orderPrice=String.valueOf(orderPriceInt);
           String orderNumber= StringUtil.initNo();
           Map<String,Object> data=new HashMap<String,Object>();
           data.put("orderPrice",orderPrice);
           data.put("orderNumber",orderNumber);
           for(int i=0;i<commodityList.size();i++){
               if(!result||!b[i]){
                   return AppResponse.notFound("提交订单失败");
               }
           }
           return AppResponse.success("提交订单成功",data);
       }else{
           return null;
       }


    }
    @Transactional
    @Override
    public AppResponse commodityCollectionList(CommodityInfo commodityInfo,String tokenFront) {
        RedisUtil redisUtil=new RedisUtil();
        if (redisUtil.getData(tokenFront)!=null){
            if (commodityInfo.getCommodityName()!=null){
                List<CollectList> collectLists=commodityCenterMapper.commodityCollectionListForSearch(commodityInfo.getCommodityName());
                Map<String,Object> data=new HashMap<>();
                data.put("collectLists",collectLists);
                if (data!=null){
                    return AppResponse.success("获取收藏列表成功",data);
                }else {
                    return AppResponse.notFound("获取收藏列表失败");
                }
            }else{

                CustomerInfo customerInfo=(CustomerInfo) redisUtil.getData(tokenFront);
                List<CollectList> collectLists=commodityCenterMapper.commodityCollectionList(customerInfo.getCustomerId());
                Map<String,Object> data=new HashMap<>();
                data.put("collectLists",collectLists);
                if (data!=null){
                    return AppResponse.success("获取收藏列表成功",data);
                }else {
                    return AppResponse.notFound("获取收藏列表失败");
                }
            }
        }else{
            return null;
        }


    }
}

