package com.neusoft.mall.goods.entity.param;

import com.neusoft.common.entity.CustomerInfo;
import lombok.Data;

import java.util.List;

@Data
public class AlterGoods {
    private String commodityId;
    private String commodityName;
    private String categoryFirst;
    private String categorySecond;
    private Long commodityRetailPrice;
    private Long commodityOriginalPrice;
    private Integer commodityIsSold;
    private Integer commodityInventory;
    List<PictureParam> pictureList;
    // private CustomerInfo customer;
    private String tokenBackend;
}
