package com.neusoft.mall.receive.Mapper;



import com.neusoft.common.entity.CustomerInfo;
import com.neusoft.mall.entity.Receive;
import com.neusoft.mall.entity.Region;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReceiveMapper {


    List<Receive> getReceiveList(CustomerInfo  customerinfo);
    

    int addReceive(Receive receive);


    int updateReceiveAllNoDefault(String customerId);


    int updateReceive(Receive receive);


    int deleteReceive(Receive receive);

    int updateReceiveByDefault(Receive receive);


    List<Region> getRegion(Region region);


    Receive getReceiveDetail(Receive receive);
}
