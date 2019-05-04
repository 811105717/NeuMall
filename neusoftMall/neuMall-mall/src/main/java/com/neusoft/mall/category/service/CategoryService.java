package com.neusoft.mall.category.service;

import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.category.entity.Category;
import com.neusoft.mall.category.entity.ReturnParam.Tree;
import com.neusoft.mall.category.entity.param.AddCategory;
import com.neusoft.mall.category.entity.param.DeleteCategory;
import com.neusoft.mall.category.entity.param.UpdateCategory;


public interface CategoryService {

    /**
     *  根据record中的属性添加分类
     * @param record Category类型
     * @return
     */
    AppResponse addCategory(AddCategory  record);

    /**
     * 根据record更新分类
     * @param record
     * @return
     */
    AppResponse updateCategory(UpdateCategory record);

    /**
     *  根据分类id更新delete栏位
     * @param params 包含主键id，后端token
     * @return 更新调条数
     */
    AppResponse deleteCategory(DeleteCategory params);

    /**
     * 直接查询所有分类信息
     * @return
     */
    Tree getCategory();

}
