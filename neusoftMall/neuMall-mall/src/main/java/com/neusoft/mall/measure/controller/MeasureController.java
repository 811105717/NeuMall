package com.neusoft.mall.measure.controller;

import com.neusoft.common.entity.BasePageVo;
import com.neusoft.common.entity.PageVo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.measure.entity.Measure;
import com.neusoft.mall.measure.entity.param.*;
import com.neusoft.mall.measure.service.MeasureService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "backend/commodityUnit")
public class MeasureController {

    @Resource
    private MeasureService measureService;


    /**
     * 添加商品单位
     * @param params 包含 单位名称，token
     * @return 固定格式，更新条数
     * @throws Exception
     */
    @ApiOperation(value = "新增商品单位")
    @PostMapping(value = "addCommodityUnit")
    public AppResponse addCommodityUnit(@RequestBody AddUnit params) throws Exception {
        try {
            return measureService.addCommodityUnit(params);
        }catch (Exception e){
            log.info("新增商品单位失败："+e);
            throw new Exception("新增商品单位!请重试");
        }

    }

    /**
     *  更新商品单位
     * @param params 包含更新的id，单位名字，版本号
     * @return 固定返回，更新条数
     * @throws Exception
     */
    @ApiOperation("更新商品单位")
    @PutMapping(value = "updateCommodityUnit")
    public AppResponse  updateCommodityUnit(@RequestBody UpdateUnit params) throws Exception {
        try {
            return measureService.updateCommodityUnit(params);
        }catch (Exception e){
            log.info("更新商品单位失败："+e);
            throw new Exception("更新商品单位! 请重试");
        }


    }


    /**
     *  删除商品单位，
     *      根据 id更新标志位
     * @param params 包含单位id
     * @return 固定返回体，更新条数
     * @throws Exception
     */
    @ApiOperation(value = "删除商品单位")
    @PutMapping(value = "deleteCommodityUnit")
    public AppResponse deleteCommodityUnit(@RequestBody DeleteUnit params) throws Exception {
        try {
            return measureService.deleteCommodityUnit(params);
        }catch (Exception e){
            log.info("删除商品单位失败："+e);
            throw new Exception("删除商品单位! 请重试");
        }
    }

    /**
     * 获取商品单位详情
     * @param params  包含单位id
     * @return 固定返回体，查询的单个商品数据
     * @throws Exception
     */
    @ApiOperation(value = "获取商品单位详情")
    @GetMapping(value = "getCommodityUnitDetail")
    public AppResponse getCommodityUnitDetail(@RequestBody GetUnit params) throws Exception {
        try{
            Measure ret=measureService.getUnitDetail(params);
            return AppResponse.success("获取商品单位成功",ret);
        }catch (Exception e) {
            log.error("获取商品单位失败" + e);
            throw new Exception("获取商品单位详情失败，请重试");
        }
    }


    /**
     * 获取商品单位列表，没有分页
     * @return 固定格式，商品单位列表
     * @throws Exception
     */
    @ApiOperation(value = "获取商品单位列表（无分页）")
    @GetMapping(value = "getCommodityUnitList")
    public AppResponse getCommodityUnitList() throws Exception {
        try{
            List<Measure> ret=measureService.getCommodityUnitList();
            return AppResponse.success("获取商品单位列表成功",ret);
        }catch (Exception e){
            log.error("获取商品单位列表失败:"+e);
            throw new Exception("获取商品单位列表失败,请重试！");
        }
    }


    /*
        分页查询的参数
     */

    /**
     * 分页获取商品单位详情，
     * @param pageVo  分页参数
     * @return 分页的商品单位列表
     * @throws Exception
     */
    @ApiOperation(value = "获取商品单位详情（分页）")
    @GetMapping(value = "getCommodityUnitListPage")
    public AppResponse getCommodityUnitListPage(@Validated UnitPage pageVo) throws Exception {

        try {
            PageVo<Measure> measurePageVo=measureService.getCommodityUnitListPage(pageVo);
            return AppResponse.success("获取商品单位详情（分页）成功",measurePageVo);
        }catch (Exception e){
            log.error("获取商品单位详情（分页）失败，"+e);
            throw new Exception("获取商品单位详情（分页）失败，请重试");
        }
    }
}
