package com.neusoft.mall.goods.entity.param;

import com.neusoft.common.entity.BasePageVo;
import lombok.Data;

@Data
public class getGoodsPageParam extends BasePageVo {
    private String categoryFirst;
    private String categorySecond;
    private String commodityCode;
    private String commodityName;
    private Integer commodityIsSold;
    private String tokenBackend;



}
