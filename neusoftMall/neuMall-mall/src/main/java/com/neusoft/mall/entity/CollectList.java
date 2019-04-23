package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @ClassName: CollectList
 * @Description:F小组
 * @Author: zhangqiang
 * @Date: 2019/4/18
 */
@Data
public class CollectList extends BaseEntity {
    private String customerId;
    private String commodityId;
    private String commodityFirstPicture;
    private String commodityName;
    private String commodityRetailPrice;
}

