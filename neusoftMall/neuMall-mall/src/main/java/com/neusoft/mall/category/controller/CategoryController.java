package com.neusoft.mall.category.controller;

import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.category.entity.Category;
import com.neusoft.mall.category.entity.ReturnParam.Tree;
import com.neusoft.mall.category.entity.param.AddCategory;
import com.neusoft.mall.category.entity.param.DeleteCategory;
import com.neusoft.mall.category.entity.param.UpdateCategory;
import com.neusoft.mall.category.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping(value = "backend/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 添加分类
     * 对传入参数使用类封装
     * @param params AddCategory类分装的参数
     * @return 特定返回内容，
     * @throws Exception 记录异常信息并返回信息
     */
    @ApiOperation(value = "添加分类")
    @PostMapping(value = "addCategory")
    public AppResponse addCategory(@RequestBody AddCategory params) throws Exception {
        try {
            return categoryService.addCategory(params);
        }catch (Exception e){
            log.info("添加分类失败"+e);
            throw new Exception("添加商品失败！请重试");
        }
    }



    /**
     * 更新分类
     *
     * @param params UpdateCategory类型
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "修改分类")
    @PutMapping(value = "updateCategory")
    public AppResponse updateCategory(@RequestBody UpdateCategory params) throws Exception {
        try {
            return categoryService.updateCategory(params);
        }catch (Exception e){
            log.info("修改分类失败"+e);
            throw new Exception("修改分类失败！请重试");
        }

    }
    /**
     *  删除分类
     *      不做级联删除
     * @param params 包含分类主键id
     * @return 固定返回体，包含更新数据条数
     * @throws Exception
     */
    @ApiOperation(value = "删除分类")
    @PutMapping(value = "deleteCategory")
    public AppResponse deleteCategory(@RequestBody DeleteCategory params) throws Exception {
        try {
            return categoryService.deleteCategory(params);
        }catch (Exception e){
            log.info("删除分类失败"+e);
            throw new Exception("删除分类失败！请重试");
        }

    }

    /**
     * 查询所有分类信息，
     *       以重构生成树行书返回
     * @return 固定返回体，包含树状信息流
     * @throws Exception
     */
    @ApiOperation(value = "查询所有分类信息")
    @GetMapping(value = "getCategory")
    public AppResponse getCateGory() throws Exception {
        try {
            Tree categoryList=categoryService.getCategory();
            return AppResponse.success("查询成功",categoryList.getChildren());
        }catch (Exception E){
            log.info("查询所有分类错误"+E);
            throw new Exception("查询所有分类失败，请重试 ");
        }
    }
}
