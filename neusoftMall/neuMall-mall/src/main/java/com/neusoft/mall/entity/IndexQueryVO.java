package com.neusoft.mall.entity;

import com.neusoft.common.entity.BasePageVo;
import lombok.Data;

/**
 * @Author: xiaobai
 * @Date: 2019/4/13 10:54
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Description 辅助类 用于首页推荐查询（分页）
 * @Version 1.0
 */
@Data
public class IndexQueryVO extends BasePageVo {
    private String commodityIsRecommend;//是否推荐
}
