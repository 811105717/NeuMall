package com.neusoft.mall.index.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.common.entity.CustomerInfo;
import com.neusoft.common.entity.PageVo;
import com.neusoft.common.response.AppResponse;

import com.neusoft.mall.entity.*;
import com.neusoft.mall.index.mapper.IndexMapper;
import com.neusoft.mall.index.service.IndexService;

import com.neusoft.mall.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: xiaobai
 * @Date: 2019/4/8 17:46
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @version 1.0
 */
@SuppressWarnings("ALL")
@Service
public class IndexServiceImpl implements IndexService {

    /**
     * 数据库操作对象
     */
    @Autowired
    private IndexMapper indexMapper;

    /**
     * 缓存操作工具
     */
    @Autowired
    private RedisUtil<CustomerInfo> redisUtil;


    /**
     * @Dept 大连东软信息学院
     * @Description 获取首页推荐信息
     * @author xiaobai
     * @date 2019/4/13
     * @param queryVO 页码和是否推荐
     * @return com.neusoft.common.response.AppResponse 结果
     */
    @Override
    public AppResponse getRecommondCommodityList(IndexQueryVO queryVO) {
        if (null != queryVO) {
            //查村数据并进行分页处理
            PageVo<CommodityInfo> list = new PageVo<>();
            PageHelper.startPage(queryVO.getPageNum(),queryVO.getPageSize());
            List<CommodityInfo> commodityInfoList = indexMapper.getCommodityList(queryVO.getCommodityIsRecommend());
            list.setList(commodityInfoList);
            list.setTotalRecords((int)new PageInfo<>(commodityInfoList).getTotal());
            //根据查询结果返回提示
            if(0!= list.getTotalRecords()){
                return AppResponse.success("推荐商品获取成功！",list);
            }else {
                return AppResponse.notFound("未查询到任何数据！");
            }
        }else {
            return AppResponse.bizError("未知参数错误！");
        }

    }
    /**
     * @Dept 大连东软信息学院
     * @Description 获取我买过的商品列表
     * @author xiaobai
     * @date 2019/4/13
     * @param customerId 用户id
     * @return com.neusoft.common.response.AppResponse 结果
     */
    @Override
    public AppResponse getBuyCommodityList(String token) {
        //先从redis中取出当前执行操作的ID
        CustomerInfo currCustomer = redisUtil.getData(token);
        if(null == currCustomer){
            return AppResponse.bizError("token失效！");
        }

        String customerId = currCustomer.getCustomerId();
        if (null != customerId && !"".equals(customerId)) {
            //commodityList 用来存储当前用户购买过的商品
            List<CommodityInfo> commodityList = new ArrayList<>(16);
            List<OrderInfo> userOrderList = indexMapper.getUserOrderList(customerId);
            if (0 == userOrderList.size()) {
                return AppResponse.notFound("未查询到数据！");
            }else {
                //所有的订单 每一个订单可能有多个商品
                for(OrderInfo o:userOrderList){
                    List<CommodityInfo> commodityInfo = indexMapper.getCommodityByOrderId(o.getOrderId());
                    if (commodityInfo != null && commodityInfo.size()!=0) {
                        //多个商品 逐个添加到购买过的商品中
                        for(CommodityInfo c: commodityInfo){
                            commodityList.add(c);
                        }
                    }
                }
                return AppResponse.success("获取列表成功！",commodityList);
            }
        }else {
            return AppResponse.bizError("未知参数错误！");
        }
    }
    /**
     * @Dept 大连东软信息学院
     * @Description 获取分类列表
     * @author xiaobai
     * @date  2019/4/13
     * @param categoryParentId 父分类ID
     * @return com.neusoft.common.response.AppResponse
     */
    @Override
    public AppResponse getClassifyList(String categoryParentId) {
        List<CateGoryInfo> cateGoryInfoList = new ArrayList<>(16);
        if(null != categoryParentId && !"".equals(categoryParentId)){
            //若父分类传 0 则获取一级分类 使用new Integer(0).toString 是为了避免魔法值
            if(new Integer(0).toString().equals(categoryParentId)){
                cateGoryInfoList = indexMapper.getParentCategory();
            }else {
                cateGoryInfoList = indexMapper.getCategoryByParent(categoryParentId);
            }
            //根据查询结果返回提示
            if (0 == cateGoryInfoList.size()) {
                return AppResponse.notFound("未查询到数据！");
            }else {
                return  AppResponse.success("分类获取成功",cateGoryInfoList);
            }
        }else {
            return  AppResponse.bizError("未知参数错误！");
        }
    }
}
