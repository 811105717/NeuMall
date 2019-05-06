package com.neusoft.mall.receive.service.impl;

import com.neusoft.common.entity.CustomerInfo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.common.util.UUIDUtil;
import com.neusoft.mall.entity.Receive;
import com.neusoft.mall.entity.Region;
import com.neusoft.mall.receive.Mapper.ReceiveMapper;
import com.neusoft.mall.receive.service.ReceiveService;
import com.neusoft.mall.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Transactional
@Service
public class ReceiveImpl implements ReceiveService {

    @Resource
    ReceiveMapper receiveMapper;
    @Autowired
    private RedisUtil redisUtil;



    @Override
    public AppResponse getReceiveList(CustomerInfo  customerinfo) {
        if (null == customerinfo ){
            return AppResponse.bizError("参数错误");
        }else {
            List<Receive> receiveList= receiveMapper.getReceiveList(customerinfo);
            if (null == receiveList || 0 == receiveList.size()){
                return AppResponse.notFound("没有查询到数据");
            }else {
                return AppResponse.success("查询成功",receiveList);
            }
        }
    }

    @Override
    public AppResponse addReceive(Receive receive, String customerId) {
        if (null == customerId || null == receive.getReceiveTel() || null == receive.getRegionCounty() || null == receive.getRegionCity() || null == receive.getReceiveContact() || null == receive.getReceiveDetailedAddress() || null == receive.getRegionProvince()){
            return AppResponse.bizError("参数错误");
        }else {
            receive.setCreatedBy(customerId);
            receive.setReceiveId(UUIDUtil.uuidStr());
            int result= receiveMapper.addReceive(receive);
            if (0 == result){
                return AppResponse.bizError("收货地址添加失败,请重试");
            }else {
                return AppResponse.success("收货地址添加成功");
            }

        }
    }


    @Override
    public AppResponse updateReceive(Receive receive) {
        if (null == receive.getReceiveId()){
            return AppResponse.bizError("参数错误");
        }else {
            int result = receiveMapper.updateReceive(receive);
            if (0 == result){
                return AppResponse.bizError("更新失败，请重试");
            }else {
                return AppResponse.success("更新成功");
            }
        }

    }


    @Override
    public AppResponse deleteReceive(Receive receive) {

        if (null == receive.getReceiveId()){
            return AppResponse.bizError("参数错误");
        }else {
            int result = receiveMapper.deleteReceive(receive);
            if (0 == result){
                return AppResponse.bizError("删除失败，请重试");
            }else {
                return AppResponse.success("删除成功");
            }
        }
    }

    @Override
    public AppResponse updateReceiveByDefault(Receive receive) {
        //需要从redis获取token

            CustomerInfo customer = (CustomerInfo) redisUtil.getData(receive.getTokenFront());
            String customerId=customer.getCustomerId();
            int rs = receiveMapper.updateReceiveAllNoDefault(customerId);
            if (0 == rs){
                return AppResponse.bizError("设置失败，请重试");
            }else {
                int result = receiveMapper.updateReceiveByDefault(receive);
                if (0 == result){
                    return AppResponse.bizError("设置失败，请重试");
                }else {
                    return AppResponse.success("设置成功");
                }
            }
       // }

    }



    @Override
    public AppResponse getRegion(Region region) {
        if (null == region.getParentRegionID()){
            return AppResponse.bizError("参数错误");
        }else {
            List<Region> regionList = receiveMapper.getRegion(region);
            return AppResponse.success("查询成功", regionList);
        }
    }


    @Override
    public AppResponse getReceiveDetail(Receive receive) {
        if (null == receive.getTokenFront() || null == receive.getReceiveId()){
            return AppResponse.bizError("参数错误");
        }else {
            Receive receiveDetail = receiveMapper.getReceiveDetail(receive);
            if (receiveDetail == null){
                return AppResponse.notFound("未查到");
            }else {
                return AppResponse.success("查询成功",receiveDetail);
            }
        }

    }


}
