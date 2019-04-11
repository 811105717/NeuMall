package com.neusoft.mall.entity;


import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Author: HiccupC
 * @Date: 2019/4/11 16:37
 * @email: 870655525@qq.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */

@Data
public class ReceiveInfo extends BaseEntity {
    private String  receiveId;//收货地址ID
    private String  regionProvince;//省ID
    private String  regionCity;//市ID
    private String  regionCountry;//区ID
    private String  receiveDetaileAddress;//详细地址
    private String  receiveTel;//联系电话
    private Integer receiveIsDefault;//是否默认，1默认，0不默认


}
