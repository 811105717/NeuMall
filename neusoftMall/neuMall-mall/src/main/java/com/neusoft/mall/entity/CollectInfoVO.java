package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: CollectInfo
 * @Description:F小组
 * @Author: zhangqiang
 * @Date: 2019/4/13
 */
@Data
public class CollectInfoVO extends BaseEntity {
    private List<CollectInfo> collectionList;
    private String tokenFront;


}

