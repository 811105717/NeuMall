package com.neusoft.mall.measure.mapper;

import com.neusoft.common.entity.BasePageVo;
import com.neusoft.mall.measure.entity.Measure;
import com.neusoft.mall.measure.entity.param.UnitPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeasureMapper {


    Measure selectByPrimaryKey(String unitId);

    Measure getMeasureByName(String name);

    List<Measure> getAllUnit();

    List<Measure> getAllUnitPage(UnitPage pageVo);

    int updateByPrimaryKeySelective(Measure record);

    int updateDelete(Measure record);

    int insertSelective(Measure record);
}