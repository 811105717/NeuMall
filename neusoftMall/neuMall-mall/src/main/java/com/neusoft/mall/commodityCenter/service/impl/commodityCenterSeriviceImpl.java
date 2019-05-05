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
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName: commodityCenterSeriviceImpl
 * @Description:F小组
 * @Author: zhangqiang
 * @Date: 2019/4/9
 */
@Service
public class commodityCenterSeriviceImpl implements commodityCenterSerivice {
    @Autowired
    private commodityCenterMapper commodityCenterMapper;
    @Autowired
    private RedisUtil<CustomerInfo> redisUtil;
    @Transactional
    @Override
    public AppResponse getCommodityList(CommodityInfo commodityInfo, BasePageVo basePageVo, String sortingTotalCount, String sortingRetailPrice) {
        PageVo pageVo = new PageVo();
        if (basePageVo.getPageSize() != null && basePageVo.getPageNum() != null) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList0();
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (basePageVo.getPageSize() != null && basePageVo.getPageNum() != null && sortingTotalCount.equals("1")) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList0ForTotalCount1();
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (basePageVo.getPageSize() != null && basePageVo.getPageNum() != null && sortingTotalCount.equals("2")) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList0ForTotalCount2();
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (basePageVo.getPageSize() != null && basePageVo.getPageNum() != null && sortingRetailPrice.equals("1")) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList0ForTetailPrice1();
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (basePageVo.getPageSize() != null && basePageVo.getPageNum() != null && sortingRetailPrice.equals("2")) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList0ForTetailPrice2();
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (commodityInfo.getCategoryFirst() != null) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList1(commodityInfo.getCategoryFirst());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (commodityInfo.getCategoryFirst() != null && sortingTotalCount.equals("1")) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList1ForTotalCount1(commodityInfo.getCategoryFirst());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (commodityInfo.getCategoryFirst() != null && sortingTotalCount.equals("2")) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList1ForTotalCount2(commodityInfo.getCategoryFirst());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (commodityInfo.getCategoryFirst() != null && sortingRetailPrice.equals("1")) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList1ForTetailPrice1(commodityInfo.getCategoryFirst());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (commodityInfo.getCategoryFirst() != null && sortingRetailPrice.equals("2")) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList1ForTetailPrice2(commodityInfo.getCategoryFirst());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (commodityInfo.getCategoryFirst() != null && commodityInfo.getCategorySecond() != null) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList2(commodityInfo.getCategoryFirst(), commodityInfo.getCategorySecond());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (commodityInfo.getCategoryFirst() != null && commodityInfo.getCategorySecond() != null && sortingTotalCount.equals("1")) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList2ForTotalCount1(commodityInfo.getCategoryFirst(), commodityInfo.getCategorySecond());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (commodityInfo.getCategoryFirst() != null && commodityInfo.getCategorySecond() != null && sortingTotalCount.equals("2")) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList2ForTotalCount2(commodityInfo.getCategoryFirst(), commodityInfo.getCategorySecond());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (commodityInfo.getCategoryFirst() != null && commodityInfo.getCategorySecond() != null && sortingRetailPrice.equals("1")) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList2ForTetailPrice1(commodityInfo.getCategoryFirst(), commodityInfo.getCategorySecond());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (commodityInfo.getCategoryFirst() != null && commodityInfo.getCategorySecond() != null && sortingRetailPrice.equals("2")) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList2ForTetailPrice2(commodityInfo.getCategoryFirst(), commodityInfo.getCategorySecond());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (commodityInfo.getCommodityName() != null) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList3(commodityInfo.getCommodityName());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (commodityInfo.getCommodityName() != null && sortingTotalCount.equals("1")) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList3ForTotalCount1(commodityInfo.getCommodityName());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (commodityInfo.getCommodityName() != null && sortingTotalCount.equals("2")) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList3ForTotalCount2(commodityInfo.getCommodityName());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (commodityInfo.getCommodityName() != null && sortingRetailPrice.equals("1")) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList3ForTetailPrice1(commodityInfo.getCommodityName());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else if (commodityInfo.getCommodityName() != null && sortingRetailPrice.equals("2")) {
            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
            List<CommodityInfo> commodityList = commodityCenterMapper.getCommodityList3ForTetailPrice2(commodityInfo.getCommodityName());
            pageVo.setList(commodityList);
            pageVo.setTotalRecords((int) new PageInfo(commodityList).getTotal());
            if (pageVo != null) {
                return AppResponse.success("获取商品表成功", pageVo);
            } else {
                return AppResponse.notFound("获取商品表失败");
            }
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public AppResponse addShoppingCart(CommodityInfo commodityInfo, ShopInfo shopInfo, String token) {
    
        CustomerInfo customerInfo = (CustomerInfo) redisUtil.getData(token);
        String shopId = UUIDUtil.uuidStr();
        Boolean result = commodityCenterMapper.addShoppingCart(shopId, commodityInfo.getCommodityId(), shopInfo.getShopNumber(), customerInfo.getCustomerId());
        if (result) {
            return AppResponse.success("加入购物车成功");
        } else {
            return AppResponse.notFound("加入购物车失败");

        }
    }

    @Transactional
    @Override
    public AppResponse getCommodityCenterDeatil(CommodityInfo commodityInfo, String token) {
        Deatilinfo data = commodityCenterMapper.getCommodityCenterDeatil(commodityInfo.getCommodityId());
        if (data != null) {
            return AppResponse.success("获取商品详情成功", data);
        } else {
            return AppResponse.notFound("获取商品详情失败");
        }

    }

    @Transactional
    @Override
    public AppResponse getCommodityCenterSimilar(CommodityInfo commodityInfo) {
        List<CommodityInfo> data = commodityCenterMapper.getCommodityCenterSimilar(commodityInfo.getCategoryFirst());

        if (data != null) {
            return AppResponse.success("获取同类商品推荐成功", data);
        } else {
            return AppResponse.notFound("获取同类商品推荐失败");
        }
    }

    @Transactional
    @Override
    public AppResponse getCommodityCenterTradin(CommodityInfo commodityInfo) {
        List<TradinInfo> data = commodityCenterMapper.getCommodityCenterTradin(commodityInfo.getCommodityId());
        if (data != null) {
            return AppResponse.success("获取交易记录推荐成功", data);
        } else {
            return AppResponse.notFound("获取交易记录推荐失败");
        }
    }

    @Transactional
    @Override
    public AppResponse getCommodityBuyNow(CommodityInfo commodityInfo, TradinInfo tradinInfo, String token) {
        TradinInfo data = commodityCenterMapper.getCommodityBuyNow(commodityInfo.getCommodityId());
        if (data != null) {
            return AppResponse.success("立即购买成功", data);
        } else {
            return AppResponse.notFound("立即购买失败");
        }
    }

    @Transactional
    @Override
    public AppResponse commodityCollection(CollectInfoVO collectInfoVO) {
        
        CustomerInfo customerInfo = (CustomerInfo) redisUtil.getData(collectInfoVO.getTokenFront());

        for (int i=0;i<collectInfoVO.getCollectionList().size();i++){
            CollectInfo collectInfo = collectInfoVO.getCollectionList().get(i);
            collectInfo.setCustomerId(customerInfo.getCustomerId());
            if (collectInfo.getCollectFlag().equals("1")) {
                String collectId = UUIDUtil.uuidStr();
                collectInfo.setCollectId(collectId);
                boolean result = commodityCenterMapper.commodityCollection(collectInfo);
                if (result) {
                    return AppResponse.success("添加收藏成功");
                } else {
                    return AppResponse.notFound("添加收藏失败");
                }
            } else {
                String c = commodityCenterMapper.commodityCollectionForId(collectInfo);
                boolean result = commodityCenterMapper.commodityCollectionForDelete(c);
                if (result) {
                    return AppResponse.success("取消收藏成功");
                } else {
                    return AppResponse.notFound("取消收藏失败");
                }
            }
        }
        return AppResponse.success("操作成功");
    }

    @Transactional
    @Override
    public AppResponse addOrder(OrderInfo orderInfo, String token) {
       
        CustomerInfo customerInfo = (CustomerInfo) redisUtil.getData(token);

        List<OrderDetailInfo> commodityList = orderInfo.getCommodityList();
        String orderId = UUIDUtil.uuidStr();
        Boolean result = commodityCenterMapper.addOrder(orderId, orderInfo.getOrderNumber(), orderInfo.getOrderPrice(), customerInfo.getCustomerId(), orderInfo.getOrderAddress(), orderInfo.getReceiveTel(), orderInfo.getReceiveContact(), orderInfo.getOrderRemark());
        String[] commodityPrice = new String[commodityList.size()];
        String[] commodityNum = new String[commodityList.size()];
        Boolean[] b = new Boolean[commodityList.size()];
        int orderPriceInt = 0;
        int[] commodityTotalPriceInt = new int[commodityList.size()];
        for (int i = 0; i < commodityList.size(); i++) {
            commodityPrice[i] = commodityCenterMapper.addOrderDetailForPrice(commodityList.get(i).getCommodityId());
            commodityNum[i] = commodityList.get(i).getCommodityNum();
            commodityTotalPriceInt[i] = Integer.parseInt(commodityPrice[i]) * Integer.parseInt(commodityNum[i]);
            orderPriceInt = orderPriceInt + Integer.parseInt(commodityPrice[i]) * Integer.parseInt(commodityNum[i]);
        }
        for (int i = 0; i < commodityList.size(); i++) {
            String orderDetailId = UUIDUtil.uuidStr();
            commodityCenterMapper.addOrderDetail(orderDetailId, orderId, commodityList.get(i).getCommodityId(), commodityPrice[i], commodityNum[i], String.valueOf(commodityTotalPriceInt[i]));
        }
        String orderPrice = String.valueOf(orderPriceInt);
        String orderNumber = StringUtil.initNo();
        List<Object> data = new ArrayList<Object>();
        data.add(orderPrice);
        data.add(orderNumber);
        return AppResponse.success("提交订单成功", data);


    }

    @Transactional
    @Override
    public AppResponse commodityCollectionList(CommodityInfo commodityInfo, String token) {
       
        CustomerInfo customerInfo = (CustomerInfo) redisUtil.getData(token);
        
        if (commodityInfo.getCommodityName() == null||"".equals(commodityInfo.getCommodityName())) {
            List<CollectList> data = commodityCenterMapper.commodityCollectionList(customerInfo.getCustomerId());

            if (data != null) {
                return AppResponse.success("获取收藏列表成功", data);
            } else {
                return AppResponse.notFound("获取收藏列表失败");
            }

        } else {

            List<CollectList> data = commodityCenterMapper.commodityCollectionListForSearch(commodityInfo.getCommodityName());

            if (data != null) {
                return AppResponse.success("获取收藏列表成功", data);
            } else {
                return AppResponse.notFound("获取收藏列表失败");
            }
        }


    }
}

