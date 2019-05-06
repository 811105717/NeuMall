package com.neusoft.mall.category.entity.param;

import com.neusoft.common.entity.CustomerInfo;
import lombok.Data;

@Data
public class DeleteCategory {
    private String categoryId;
    private String tokenBackend;
    // private CustomerInfo customer;
}
