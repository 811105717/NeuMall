package com.neusoft.common.entity;

import lombok.Data;

/**
 * @ClassName: BaseEntity
 * @Description:
 * @Author: shengtt
 * @Date: 2019/4/2
 */
@Data
public class BaseEntity {
    private String createdBy;//创建人
    private String gmtCreate;//创建时间
    private String lastModifiedBy;//更新人
    private String gmtModified;//更新时间
    private int isDeleted;//是否作废1表示作废，0表示未作废
    private int sortNo;//序号
    private int version;//版本号

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
