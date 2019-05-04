package com.neusoft.mall.measure.service;

import com.neusoft.common.entity.BasePageVo;
import com.neusoft.common.entity.PageVo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.measure.entity.Measure;
import com.neusoft.mall.measure.entity.param.*;

import java.util.List;

public interface MeasureService {

    /**
     *  添加商品单位
     * @param params
     * @return 更新条数
     */
    AppResponse addCommodityUnit(AddUnit params);

    /**
     *  更新商品单位信息
     * @param measure 包含更新的id，单位名字，版本号
     * @return 更新条数
     */
    AppResponse updateCommodityUnit(UpdateUnit measure);

    /**
     * 添加商品单位
     * @param params 包括单位id，token
     * @return 更新条数
     */
    AppResponse deleteCommodityUnit(DeleteUnit params);

    /**
     * 获取单个商品单位全部信息
     * @param params 包括单位id，token
     * @return 单个商品全部信息
     */
    Measure getUnitDetail(GetUnit params);

    /**
     * 获取商品单位列表
     * @return 商品单位列表
     */
    List<Measure> getCommodityUnitList();

    /**
     * 分页获取商品单位列表
     * @param pageVo 分页参数
     * @return 分页的商品列表
     */
    PageVo<Measure> getCommodityUnitListPage(UnitPage pageVo);
}
