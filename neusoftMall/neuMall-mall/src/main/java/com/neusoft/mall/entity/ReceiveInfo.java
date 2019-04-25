package com.neusoft.mall.entity;


import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Author: HiccupC
 * @Date: 2019/4/11 16:37
 * @email: 870655525@qq.com
 * @address: 大连东软信息学院
 * @Description 实体类 对应收货地址表
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

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public String getRegionProvince() {
        return regionProvince;
    }

    public void setRegionProvince(String regionProvince) {
        this.regionProvince = regionProvince;
    }

    public String getRegionCity() {
        return regionCity;
    }

    public void setRegionCity(String regionCity) {
        this.regionCity = regionCity;
    }

    public String getRegionCountry() {
        return regionCountry;
    }

    public void setRegionCountry(String regionCountry) {
        this.regionCountry = regionCountry;
    }

    public String getReceiveDetaileAddress() {
        return receiveDetaileAddress;
    }

    public void setReceiveDetaileAddress(String receiveDetaileAddress) {
        this.receiveDetaileAddress = receiveDetaileAddress;
    }

    public String getReceiveTel() {
        return receiveTel;
    }

    public void setReceiveTel(String receiveTel) {
        this.receiveTel = receiveTel;
    }

    public Integer getReceiveIsDefault() {
        return receiveIsDefault;
    }

    public void setReceiveIsDefault(Integer receiveIsDefault) {
        this.receiveIsDefault = receiveIsDefault;
    }
}
