package com.neusoft.mall.goods.entity.param;

import com.neusoft.common.entity.CustomerInfo;
import lombok.Data;

@Data
public class UpdateIsSell {
    private String commodityId;
    private int commodityIsSold;
    private int version;
    // private CustomerInfo customer;
    private String tokenBackend;
}
