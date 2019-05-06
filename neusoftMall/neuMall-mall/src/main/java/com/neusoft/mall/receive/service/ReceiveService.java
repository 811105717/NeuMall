package com.neusoft.mall.receive.service;

import com.neusoft.common.entity.CustomerInfo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.Receive;
import com.neusoft.mall.entity.Region;


public interface ReceiveService {
    AppResponse getReceiveList(CustomerInfo  customerinfo);

    AppResponse addReceive(Receive receive, String customerId);

    AppResponse updateReceiveByDefault(Receive receive);

    AppResponse deleteReceive(Receive receive);

    AppResponse getRegion(Region region);

    AppResponse updateReceive(Receive receive);

    AppResponse getReceiveDetail(Receive receive);
}
