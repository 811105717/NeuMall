package com.neusoft.mall.measure.entity.param;

import com.neusoft.common.entity.BasePageVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UnitPage  {
    private String unitName;
    @ApiModelProperty(value = "分页查询页码数")
    private Integer pageNum ;
    @ApiModelProperty(value = "分页查询每页查询条数")
    private Integer pageSize ;
}
