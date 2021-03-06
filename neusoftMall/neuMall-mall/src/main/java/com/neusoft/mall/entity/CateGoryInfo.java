package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @author: xiaobai
 * @date: 2019/4/11 18:38
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Description 实体类 对应数据库表中的 t_cateGory
 * @Version 1.0
 */
@Data
@SuppressWarnings("ALL")
public class CateGoryInfo extends BaseEntity {
    /**
     * 分类ID
     */
    private String categoryId;
    /**
     * 上级分类ID
     */
    private String categoryParentId;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 层级 1 一级 2 二级
     */
    private String categoryLevel;
    /**
     * 树状查询码
     */
    @Deprecated
    private String categoryTreeCode;
    /**
     * 备注
     */
    private String categoryRemark;

}
