package com.neusoft.mall.category.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Category {
    private String categoryId;

    private String categoryParentId;

    private String categoryName;

    private Integer categoryLevel;

    private String categoryTreeCode;

    private String categoryRemark;

    private String createdBy;

    private Date gmtCreate;

    private String lastModifiedBy;

    private Date gmtModified;

    private Integer isDeleted;

    private Integer sortNo;

    private Integer version;

    private List<Category> child;
}