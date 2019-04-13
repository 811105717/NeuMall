package com.neusoft.mall.index.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.common.entity.PageVo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.CateGoryInfo;
import com.neusoft.mall.entity.CommodityInfo;
import com.neusoft.mall.entity.IndexQueryVO;
import com.neusoft.mall.entity.OrderInfo;
import com.neusoft.mall.index.mapper.IndexMapper;
import com.neusoft.mall.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: xiaobai
 * @Date: 2019/4/8 17:46
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@SuppressWarnings("ALL")
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexMapper indexMapper;


    /**
     * @Dept：大连东软信息学院
     * @Description： 获取首页推荐信息
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：queryVO 页码和是否推荐
     * @Return：com.neusoft.common.response.AppResponse
     */
    @Override
    public AppResponse getRecommondCommodityList(IndexQueryVO queryVO) {
        if (null != queryVO) {
            //分页
            PageVo<CommodityInfo> list = new PageVo<>();
            PageHelper.startPage(queryVO.getPageNum(),queryVO.getPageSize());
            List<CommodityInfo> commodityInfoList = indexMapper.getCommodityList(queryVO.getCommodityIsRecommend());
            list.setList(commodityInfoList);
            list.setTotalRecords((int)new PageInfo<>(commodityInfoList).getTotal());
            if(0!= list.getTotalRecords()){
                //查到东西了
                return AppResponse.success("推荐商品获取成功！",list);
            }else {
                return AppResponse.bizError("未查询到任何数据！");
            }
        }else {
            return AppResponse.bizError("未知数据错误！");
        }

    }
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取我买过的商品列表
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：customerId 用户id
     * @Return：com.neusoft.common.response.AppResponse
     */
    @Override
    public AppResponse getBuyCommodityList(String customerId) {
        // 先查用户所有订单  根据订单查所有买过的商品  然后返回
        if (null != customerId && !"".equals(customerId)) {
            //用来存储用户所有的订单
            List<CommodityInfo> commodityList = new ArrayList<>(16);
            List<OrderInfo> userOrderList = indexMapper.getUserOrderList(customerId);
            if (0 == userOrderList.size()) {
                return AppResponse.notFound("未查询到数据！");
            }else {
                for(OrderInfo o:userOrderList){
                    CommodityInfo commodityInfo = indexMapper.getCommodityByOrderId(o.getOrderId());
                    if (commodityInfo != null) {
                        //有的订单可能被逻辑删除了
                        commodityList.add(commodityInfo);
                    }
                }
                return AppResponse.success("获取列表成功！",commodityList);
            }
        }else {
            return AppResponse.bizError("未知数据错误！");
        }
    }
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取二级分类列表
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：categoryParentId 父分类
     * @Return：com.neusoft.common.response.AppResponse
     */
    @Override
    public AppResponse getClassifyList(String categoryParentId) {
        if(null != categoryParentId && !"".equals(categoryParentId)){
            List<CateGoryInfo> cateGoryInfoList = indexMapper.getCategoryByParent(categoryParentId);
            if (0 == cateGoryInfoList.size()) {
                return AppResponse.notFound("未查询到数据！");
            }else {
                return  AppResponse.success("二级分类获取成功",cateGoryInfoList);
            }
        }else {
            return  AppResponse.bizError("未知数据错误！");
        }
    }
}
