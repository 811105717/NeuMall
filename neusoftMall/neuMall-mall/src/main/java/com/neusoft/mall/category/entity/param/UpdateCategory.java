package com.neusoft.mall.category.entity.param;

import com.neusoft.common.entity.CustomerInfo;
import lombok.Data;

@Data
public class UpdateCategory {
    private String tokenBackend;
    private String categoryName;
    private String categoryId;
    private String categoryRemark;
    private int sortNo;
    private int version;
    // private CustomerInfo customer;
}
