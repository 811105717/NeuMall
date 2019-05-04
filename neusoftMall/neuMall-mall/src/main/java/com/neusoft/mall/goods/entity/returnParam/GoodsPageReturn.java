package com.neusoft.mall.goods.entity.returnParam;

import com.neusoft.mall.category.entity.Category;
import lombok.Data;

import java.util.List;

@Data
public class GoodsPageReturn {
    private String commodityName;
    private Category categoryFirst;
    private String categorySecond;
    private String categorySecondName;
    private Long commodityRetailPrice;
    private Long commodityOriginalPrice;
    private Integer commodityIsSold;
    private Integer commodityInventory;
    private List<PictureList> pictureList;

}
