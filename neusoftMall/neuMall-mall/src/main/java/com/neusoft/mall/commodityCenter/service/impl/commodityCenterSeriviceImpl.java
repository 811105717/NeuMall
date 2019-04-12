package com.neusoft.mall.commodityCenter.service.impl;
import com.neusoft.common.entity.BasePageVo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.common.util.StringUtil;
import com.neusoft.mall.commodityCenter.mapper.commodityCenterMapper;
import com.neusoft.mall.commodityCenter.service.commodityCenterSerivice;
import com.neusoft.mall.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        int start=(basePageVo.getPageNum()-1)*basePageVo.getPageSize()+1;
        int end=basePageVo.getPageNum()*basePageVo.getPageSize();
        if (sortingTotalCount.equals("1")){
            List<CommodityInfo> commodityList=commodityCenterMapper.getCommodityListForTotalCount1(commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond(),start,end);
            int totalRecords=commodityCenterMapper.getCommodityListForTotalRecords(commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond());
            Map<String,Object> data=null;
            data.put("list",commodityList);
            data.put("totalRecords",totalRecords);
            if(data!=null){
                return AppResponse.success("获取商品表成功",data);
            }else{
                return AppResponse.notFound("获取商品表失败");
            }
       }else if (sortingTotalCount.equals("2")){
            List<CommodityInfo> commodityList=commodityCenterMapper.getCommodityListForTotalCount2(commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond(),start,end);
            int totalRecords=commodityCenterMapper.getCommodityListForTotalRecords(commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond());
            Map<String,Object> data=null;
            data.put("list",commodityList);
            data.put("totalRecords",totalRecords);
            if(data!=null){
                return AppResponse.success("获取商品表成功",data);
            }else{
                return AppResponse.notFound("获取商品表失败");
            }
        }else if (sortingRetailPrice.equals("1")){
            List<CommodityInfo> commodityList=commodityCenterMapper.getCommodityListForTetailPrice1(commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond(),start,end);
            int totalRecords=commodityCenterMapper.getCommodityListForTotalRecords(commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond());
            Map<String,Object> data=null;
            data.put("list",commodityList);
            data.put("totalRecords",totalRecords);
            if(data!=null){
                return AppResponse.success("获取商品表成功",data);
            }else{
                return AppResponse.notFound("获取商品表失败");
            }
        }else if (sortingRetailPrice.equals("2")){
            List<CommodityInfo> commodityList=commodityCenterMapper.getCommodityListForTetailPrice2(commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond(),start,end);
            int totalRecords=commodityCenterMapper.getCommodityListForTotalRecords(commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond());
            Map<String,Object> data=null;
            data.put("list",commodityList);
            data.put("totalRecords",totalRecords);
            if(data!=null){
                return AppResponse.success("获取商品表成功",data);
            }else{
                return AppResponse.notFound("获取商品表失败");
            }
        }else if (commodityInfo.getCommodityName()!=null){
            List<CommodityInfo> commodityList=commodityCenterMapper.getCommodityListForName(commodityInfo.getCommodityName(),commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond(),start,end);
            int totalRecords=commodityCenterMapper.getCommodityListForNameForTotalRecords(commodityInfo.getCommodityName(),commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond());
            Map<String,Object> data=null;
            data.put("list",commodityList);
            data.put("totalRecords",totalRecords);
            if(data!=null){
                return AppResponse.success("获取商品表成功",data);
            }else{
                return AppResponse.notFound("获取商品表失败");
            }
        }else{
            List<CommodityInfo> commodityList=commodityCenterMapper.getCommodityList(commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond(),start,end);
            int totalRecords=commodityCenterMapper.getCommodityListForTotalRecords(commodityInfo.getCategoryFirst(),commodityInfo.getCategorySecond());
            Map<String,Object> data=null;
            data.put("list",commodityList);
            data.put("totalRecords",totalRecords);
            if(data!=null){
                return AppResponse.success("获取商品表成功",data);
            }else{
                return AppResponse.notFound("获取商品表失败");
            }
        }
    }

    @Override
    public AppResponse addShoppingCart(CommodityInfo commodityInfo, OrderDetail orderDetail, CustomerInfo customerInfo) {
        return null;
    }
    @Transactional
    @Override
    public AppResponse getCommodityCenterDeatil(CommodityInfo commodityInfo) {
        String isCollect;
        CommodityInfo deatil=commodityCenterMapper.getCommodityCenterDeatil(commodityInfo.getCommodityId());
        List<String> picturelist=commodityCenterMapper.getCommodityCenterDeatilForPic(commodityInfo.getCommodityId());
        List<String> collect=commodityCenterMapper.getCommodityCenterDeatilForCollect(commodityInfo.getCommodityId());
        if(collect!=null){
           isCollect="0";
        }else{
            isCollect="1";
        }
        Map<String,Object> data=null;
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
        String commodityPrice=commodityCenterMapper.getCommodityBuyNowForPrice(commodityInfo.getCommodityId());
        int commodityTotalPriceInt=Integer.parseInt(commodityNum)*Integer.parseInt(commodityPrice);
        String commodityTotalPrice=String.valueOf(commodityTotalPriceInt);
        Map<String,Object> data=null;
        data.put("commodity",commodity);
        data.put("commodityPrice",commodityPrice);
        data.put("commodityTotalPrice",commodityTotalPrice);
        if(data!=null){
            return AppResponse.success("立即购买成功",data);
        }else{
            return AppResponse.notFound("立即购买失败");
        }
    }

    @Override
    public AppResponse commodityCollection() {
        return null;
    }
    @Transactional
    @Override
    public AppResponse addOrder(OrderInfo orderInfo, List<OrderDetail> commodityList) {
        Boolean result=commodityCenterMapper.addOrder(orderInfo.getOrderNumber(),orderInfo.getOrderPrice(),orderInfo.getCustomerId(),orderInfo.getOrderAddress(),orderInfo.getReceiveTel(),orderInfo.getReceiveContact(),orderInfo.getOrderRemark());
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
            commodityCenterMapper.addOrderDetail(commodityList.get(i).getCommodityId(),commodityPrice[i],commodityNum[i],String.valueOf(commodityTotalPriceInt[i]));
        }
        String orderPrice=String.valueOf(orderPriceInt);
        String orderNumber= StringUtil.initNo();
        Map<String,Object> data=null;
        data.put("orderPrice",orderPrice);
        data.put("orderNumber",orderNumber);
        for(int i=0;i<commodityList.size();i++){
            if(!result||!b[i]){
                return AppResponse.notFound("提交订单失败");
            }
        }
        return AppResponse.success("提交订单成功",data);
    }
}

