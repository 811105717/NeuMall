package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Author: xiaobai
 * @Date: 2019/4/11 18:38
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@Data
public class CateGoryInfo extends BaseEntity {
    private String categoryId; //分类ID
    private String categoryParentId;//上级分类ID
    private String categoryName; //分类名称
    private String categoryLevel; //层级 1 一级 2 二级
    private String categoryTreeCode; //树状查询码
    private String categoryRemark;//备注
}
