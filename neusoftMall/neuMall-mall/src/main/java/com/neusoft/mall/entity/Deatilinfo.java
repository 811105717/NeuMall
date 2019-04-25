package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @ClassName: Deatilinfo
 * @Description:F小组
 * @Author: zhangqiang
 * @Date: 2019/4/25
 */
@Data
public class Deatilinfo extends BaseEntity{
    private String commodityCode; //商品编号
    private String pictureAddress;
    private String commodityName; //商品名称
    private String commodityRetailPrice; //零售价
    private String commodityOriginalPrice; //原价
    private String commodityColor; //颜色
    private String commodityIsLack; //是否缺货 1是0否
    private String commodityUnitId; //购买单位
    private String commodityTotalCount; //销量
    private String pictureIsFistPicture;
}

