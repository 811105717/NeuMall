package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Author: fwk
 * @Description:
 * @Date: Create in 22:17 2019/4/11
 */
@Data
public class CommodityListInfo extends BaseEntity {
    private String pictureAddress;
    private String commodityName;
    private String commodityCode;
    private String commodityFirstPicture;
    private String commodityPrice;
    private String commodityNum;
    private String commodityTotalPrice;
}
