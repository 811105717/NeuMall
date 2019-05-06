package com.neusoft.mall.goods.controller;

import com.neusoft.common.entity.PageVo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.goods.entity.Goods;
import com.neusoft.mall.goods.entity.param.*;
import com.neusoft.mall.goods.entity.returnParam.GoodsReturn;
import com.neusoft.mall.goods.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping(value = "backend/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;


    /**
     * 新增商品
     * @param addGoods 添加商品的属性
     * @return 更新条数
     * @throws Exception
     */
    @ApiOperation(value = "新增商品")
    @PostMapping(value = "addGoods")
    public AppResponse addGoods(@RequestBody AddGoods addGoods) throws Exception {
        try{
            return goodsService.addGoods(addGoods);
        }catch (Exception e){
            log.info("新增商品失败！"+e);
            throw new Exception("新增商品失败，请重试");
        }
    }


    /**
     * 修改商品信息
     * @param alterGoods 修改商品的参数
     * @return 更新的条数
     */
    @ApiOperation("修改商品信息")
    @PutMapping(value = "updateGoods")
    public AppResponse updateGoods(@RequestBody AlterGoods alterGoods) throws Exception {
        try {
            return goodsService.AlterGoods(alterGoods);
        }catch (Exception e){
            log.info("修改商品失败！"+e);
            throw new Exception("修改商品失败，请重试");
        }

    }

    /**
     * 删除对应商品信息
     * @param commodityId 商品id
     * @return 删除条数
     * @throws Exception
     */
    @ApiOperation(value = "商品信息删除")
    @PutMapping(value = "deleteGoods")
    public AppResponse deleteGoods( String commodityId) throws Exception {
            try {
                return goodsService.deleteGoods(commodityId);
            }catch (Exception e){
                log.info("删除商品失败！"+e);
                throw new Exception("删除商品失败，请重试");
            }
    }

    /*
        1.没有根据version更新
     */


    /**
     * 商品上架与下架
     * @param params 更新商品参数
     * @return 更新条数
     * @throws Exception
     */
    @ApiOperation(value = "商品上架/下架")
    @PutMapping(value = "updateGoodsIsSell")
    public AppResponse updateGoodsIsSell(@RequestBody UpdateIsSell params) throws Exception {
        try {
            return goodsService.updateGoodsIsSell(params);
        }catch (Exception e){
            log.info("商品上架/下架失败！"+e);
            throw new Exception("商品上架/下架失败，请重试");
        }
    }

    /**
     * 获取商品详情
     * @param commodityId 商品id
     * @return 单个商品的详细信息
     * @throws Exception
     */
    @ApiOperation("查询商品详情")
    @GetMapping(value = "getGoodsDetail")
    public AppResponse getGoodsDetail(@RequestBody GetGoodsDetail goodsDetail) throws Exception {
        try{
            GoodsReturn goodsReturn=goodsService.getGoodsDetail(goodsDetail);
            if (goodsReturn!=null){
                return AppResponse.success("查询成功",goodsReturn);
            }
            return AppResponse.bizError("查询商品详情失败");
        }catch (Exception e){
            log.info("查询商品详情失败！"+e);
            throw new Exception("查询商品详情失败，请重试");
        }
    }


    /**
     * 分页获取商品列表
     * @param pageParam 分页参数
     * @return 分页后的上皮列表
     */
    @ApiOperation("查询商品列表（分页）")
    @GetMapping(value = "getGoodsList")
    public AppResponse getGoodsList(getGoodsPageParam pageParam) throws Exception {
        try {
            PageVo<Goods> pageVo=goodsService.getGoodsPage(pageParam);
            return AppResponse.success("查询商品列表成功（分页）",pageVo);
        }catch (Exception e){
            throw new Exception("查询商品列表成功（分页）失败，请重试");
        }

    }

    /**
     * 上传图片到服务器
     * @param multipartFile 上传文件参数
     * @return 图片地址
     * @throws Exception
     */
    @ApiOperation("上传图片")
    @PostMapping(value = "uploadFile")
    public AppResponse uploadFile(@RequestParam("file") MultipartFile multipartFile[]) throws Exception{
        try {
            Map<String, Object> param = new HashMap<>();
            param.put("files", multipartFile);
            Map<String, String> resultParam = goodsService.uploadFile(param);
            return AppResponse.success("上传成功",resultParam);
        } catch (Exception e) {
            throw new Exception(this.getClass() + "uploadFile() Exception:" + e);
        }
    }




}
