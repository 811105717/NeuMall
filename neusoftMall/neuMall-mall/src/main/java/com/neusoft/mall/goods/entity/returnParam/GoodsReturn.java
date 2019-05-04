package com.neusoft.mall.goods.entity.returnParam;

import lombok.Data;

import java.util.List;

@Data
public class GoodsReturn {
    private String  commodityId;
    private String commodityName;
    private String categoryFirst;
    private String categoryFirstName;
    private String categorySecond;
    private Integer version;
    private String commodityTotalCount;
    private String commodityIsRecommend;
    private String commodityUnitId;
    private String commodityColor;
    private String commodityDesc;
    private String categorySecondName;
    private Long commodityRetailPrice;
    private Long commodityOriginalPrice;
    private Integer commodityIsSold;
    private Integer commodityInventory;
    private List<PictureList> pictureList;

}
