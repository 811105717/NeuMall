package com.neusoft.mall.measure.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.common.entity.BasePageVo;
import com.neusoft.common.entity.CustomerInfo;
import com.neusoft.common.entity.PageVo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.common.util.UUIDUtil;
import com.neusoft.mall.measure.entity.Measure;
import com.neusoft.mall.measure.entity.param.*;
import com.neusoft.mall.measure.mapper.MeasureMapper;
import com.neusoft.mall.measure.service.MeasureService;
import com.neusoft.mall.util.RedisUtil;
import jdk.management.resource.internal.ApproverGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class MeasureServiceImpl implements MeasureService {
    @Resource
    private MeasureMapper measureMapper;
    @Autowired
    private RedisUtil<CustomerInfo> redisUtil;


    /**
     * 添加商品分类
     *      判断是否有重名分类，
     *      没有重复添加
     * @param params 包含添加的分类名称，token
     * @return 更新条数
     */
    @Override
    public AppResponse addCommodityUnit(AddUnit params) {
        Measure name=measureMapper.getMeasureByName(params.getUnitName());
        if (name!=null){
            return AppResponse.bizError("添加商品单位失败，单位名称重复");
        }
        CustomerInfo currCustomer = redisUtil.getData(params.getCustomer().getTokenFront());
        String user=currCustomer.getCustomerId();
        Measure measure=new Measure();
        measure.setUnitId(UUIDUtil.uuidStr());
        measure.setUnitName(params.getUnitName());
        measure.setCreatedBy(user);
        measure.setGmtCreate(new Date());
        measure.setLastModifiedBy(user);
        measure.setGmtModified(new Date());
        measure.setIsDeleted(0);
        measure.setSortNo(1);
        measure.setVersion(1);
        int res=measureMapper.insertSelective(measure);
        if (res!=0){
            return AppResponse.success("添加单位成功",res);
        }
        return AppResponse.bizError("添加单位失败");
    }

    /**
     * 更新商品单位信息
     * @param record 单位id，名字 ，版本号，token
     * @return 更新条数
     */
    @Override
    public AppResponse updateCommodityUnit(UpdateUnit record) {
        CustomerInfo currCustomer = redisUtil.getData(record.getCustomer().getTokenFront());
        String user=currCustomer.getCustomerId();
        Measure measure=new Measure();
        measure.setUnitName(record.getUnitName());
        measure.setUnitId(record.getUnitId());
        measure.setVersion(record.getVersion());
        measure.setGmtModified(new Date());
        measure.setLastModifiedBy(user);
        int res=measureMapper.updateByPrimaryKeySelective(measure);
        if (res!=0){
            return AppResponse.success("更新单位成功",res);
        }
        return AppResponse.bizError("更新单位失败");
    }

    /**
     * 删除商品单位，
     *      更新删除标志位
     * @param params 包括单位id，token
     * @return 更新条数
     */
    @Override
    public AppResponse deleteCommodityUnit(DeleteUnit params) {
         CustomerInfo currCustomer = redisUtil.getData(params.getCustomer().getTokenFront());
         String user=currCustomer.getCustomerId();
         Measure measure=new Measure();
         measure.setUnitId(params.getUnitId());
         measure.setLastModifiedBy(user);
         measure.setGmtModified(new Date());
         int res=measureMapper.updateDelete(measure);
         if (res!=0){
             return AppResponse.success("删除商品单位成功",res);
         }
         return AppResponse.bizError("删除商品单位失败");
    }

    /**
     * 获取单个商品单位全部信息
     * @param params 包括单位id，token
     * @return 单个商品单位全部信息
     */
    @Override
    public Measure getUnitDetail(GetUnit params) {
        Measure ret=measureMapper.selectByPrimaryKey(params.getUnitId());
        if (ret!=null){
            return ret;
        }
        return null;
    }

    /**
     *获取商品单位列表
     * @return 商品单位列表
     */
    @Override
    public List<Measure> getCommodityUnitList() {
        List<Measure> ret=measureMapper.getAllUnit();
        return ret;
    }

    /**
     * 获取分页商品单位列表
     * @param pageVo 分页参数
     * @return 分页的单位列表
     */
    @Override
    public PageVo<Measure> getCommodityUnitListPage(UnitPage pageVo) {
        PageVo<Measure> pageMeasure=new PageVo<>();
        PageHelper.offsetPage((pageVo.getPageNum()-1) * pageVo.getPageSize(),pageVo.getPageSize());
        List<Measure> listMeasure=measureMapper.getAllUnitPage(pageVo);
        PageInfo<Measure> pageInfo=new PageInfo<>(listMeasure);
        pageMeasure.setList(listMeasure);
        pageMeasure.setTotalRecords((int) pageInfo.getTotal());
        return pageMeasure;
    }
}
