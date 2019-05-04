package com.neusoft.mall.category.entity.ReturnParam;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Tree {
    private String id;
    private String label;
    private Object attributes;
//    private String categoryName;
//    private String categoryId;
//    private String categoryParentId;
//    private String categoryLevel;
//    private String categoryRemark;
//    private int sortNo;
//    private int version;
    private String ccpid;
    private Integer type;
    private List<Tree> children =new ArrayList<>();



}
