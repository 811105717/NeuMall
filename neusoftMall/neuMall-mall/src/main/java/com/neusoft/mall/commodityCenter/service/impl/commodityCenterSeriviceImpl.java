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
        }else{
            PageHelper.startPage(basePageVo.getPageNum(),basePageVo.getPageSize());
            List<CommodityInfo> commodityList=commodityCenterMapper.getCommodityList(commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond());
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
    public AppResponse addShoppingCart(CommodityInfo commodityInfo, String shopNumber, CustomerInfo customerInfo) {
        String shopId= UUIDUtil.uuidStr();
        Boolean result=commodityCenterMapper.addShoppingCart(shopId,commodityInfo.getCommodityId(),shopNumber,customerInfo.getCustomerId());
        if (result){
            return AppResponse.success("加入购物车成功");
        }else {
            return AppResponse.notFound("加入购物车失败");
        }

    }
    @Transactional
    @Override
    public AppResponse getCommodityCenterDeatil(CommodityInfo commodityInfo) {
        CommodityInfo deatil=commodityCenterMapper.getCommodityCenterDeatil(commodityInfo.getCommodityId());
        List<String> picturelist=commodityCenterMapper.getCommodityCenterDeatilForPic(commodityInfo.getCommodityId());
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("deatil",deatil);
        data.put("picturelist",picturelist);
        if(data!=null){
            return AppResponse.success("获取商品详情成功",data);
        }else{
            return AppResponse.notFound("获取商品详情失败");
        }

    }
    @Transactional
    @Override
    public AppResponse getCommodityCenterSimilar(CommodityInfo commodityInfo) {
        List<CommodityInfo> data=commodityCenterMapper.getCommodityCenterSimilar(commodityInfo.getCategoryFirst());
        if(data!=null){
            return AppResponse.success("获取同类商品推荐成功",data);
        }else{
            return AppResponse.notFound("获取同类商品推荐失败");
        }
    }
    @Transactional
    @Override
    public AppResponse getCommodityCenterTradin(CommodityInfo commodityInfo) {
        List<String> data=commodityCenterMapper.getCommodityCenterTradin(commodityInfo.getCommodityId());
        if(data!=null){
            return AppResponse.success("获取交易记录推荐成功",data);
        }else{
            return AppResponse.notFound("获取交易记录推荐失败");
        }
    }
    @Transactional
    @Override
    public AppResponse getCommodityBuyNow(CommodityInfo commodityInfo,String commodityNum) {
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
    }
    @Transactional
    @Override
    public AppResponse commodityCollection(CollectInfo collectInfo,String collectFlag) {
        if (collectFlag.equals("1")){
            String collectId=UUIDUtil.uuidStr();
            boolean result=commodityCenterMapper.commodityCollection(collectId,collectInfo.getCustomerId(),collectInfo.getCommodityId());
            if (result){
                return AppResponse.success("添加收藏成功");
            }else {
                return  AppResponse.notFound("添加收藏失败");
            }
        }else{
            boolean result=commodityCenterMapper.commodityCollectionForDelete(collectInfo.getCustomerId(),collectInfo.getCommodityId());
            if (result){
                return AppResponse.success("取消收藏成功");
            }else {
                return  AppResponse.notFound("取消收藏失败");
            }
        }
    }
    @Transactional
    @Override
    public AppResponse addOrder(OrderInfo orderInfo, List<OrderDetail> commodityList) {
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
            commodityCenterMapper.addOrderDetail(orderDetailId,commodityList.get(i).getCommodityId(),commodityPrice[i],commodityNum[i],String.valueOf(commodityTotalPriceInt[i]));
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
    }
    @Transactional
    @Override
    public AppResponse commodityCollectionList(CollectInfo collectInfo) {
        List<String> data=commodityCenterMapper.commodityCollectionList(collectInfo.getCustomerId());
       if (data!=null){
           return AppResponse.success("获取收藏列表成功",data);
       }else {
           return AppResponse.notFound("获取收藏列表失败");
       }

    }
}

