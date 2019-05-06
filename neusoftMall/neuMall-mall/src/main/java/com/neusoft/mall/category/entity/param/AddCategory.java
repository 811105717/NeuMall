package com.neusoft.mall.category.entity.param;

import com.neusoft.common.entity.CustomerInfo;
import lombok.Data;

@Data
public class AddCategory {
    private String tokenBackend;
    private String categoryName;
    private String categoryParentId;
    private String categoryRemark;
    private int sortNo;
    private int version;
    // private CustomerInfo customer;
}
