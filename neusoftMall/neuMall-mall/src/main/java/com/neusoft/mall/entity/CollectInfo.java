package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @ClassName: CollectInfo
 * @Description:F小组
 * @Author: zhangqiang
 * @Date: 2019/4/13
 */
@Data
public class CollectInfo extends BaseEntity {
    private String collectId;
    private String customerId;
    private String commodityId;
}

