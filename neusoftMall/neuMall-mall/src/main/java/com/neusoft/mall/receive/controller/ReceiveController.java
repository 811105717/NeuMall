package com.neusoft.mall.receive.controller;

import com.neusoft.common.entity.CustomerInfo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.Receive;
import com.neusoft.mall.entity.Region;
import com.neusoft.mall.receive.service.ReceiveService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.neusoft.mall.util.RedisUtil;

import javax.annotation.Resource;

@RestController
@RequestMapping("/front/receive")
@Slf4j
@Api("收货地址管理")
@CrossOrigin
public class ReceiveController {

    @Resource
    ReceiveService receiveService;
    @Autowired
    private RedisUtil redisUtil;


    @GetMapping("/getReceiveList")
    public AppResponse getReceiveList(CustomerInfo customer){
        CustomerInfo  customerinfo= (CustomerInfo) redisUtil.getData(customer.getTokenFront());
        if ( customerinfo == null ){
            return AppResponse.bizError("token失效");
        }


        return receiveService.getReceiveList(customerinfo);
    }

    @PostMapping(value = "addReceive")
    public AppResponse addReceive(Receive receive, CustomerInfo customer){
        CustomerInfo  customerinfo= (CustomerInfo) redisUtil.getData(customer.getTokenFront());
        if ( customerinfo == null ){
            return AppResponse.bizError("token失效");
        }
        String customerId = customerinfo.getCustomerId();
            return receiveService.addReceive(receive,customerId);
    }


    @PutMapping(value = "/updateReceive")
    public AppResponse updateReceive(Receive receive){
        return receiveService.updateReceive(receive);
    }


    @PutMapping(value = "/deleteReceive")
    public AppResponse deleteReceive(Receive receive){
        return receiveService.deleteReceive(receive);
    }


    @PutMapping(value = "/updateReceiveByDefault")
    public AppResponse updateReceiveByDefault(Receive receive){
        return receiveService.updateReceiveByDefault(receive);
    }


    @GetMapping(value = "/getRegion")
    public AppResponse getRegion(Region region){
        return receiveService.getRegion(region);
    }


    @GetMapping(value = "/getReceiveDetail")
    public AppResponse getReceiveDetail(Receive receive){
      return receiveService.getReceiveDetail(receive);
    }
}
