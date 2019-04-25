package com.neusoft.admin.menu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 部门：软件开发事业部
 * 描述：略
 * 作成者：xywang
 * 作成时间：2018/4/17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)//启用链式,如dept.setDname("xywang").setDb_source("test")
public class Menu {

    private String id;

    private String menuId;

    private String menuName;

    private String menuType;

    private String menuUrl;

    private String parentMenuId;

    private String menuComments;

    private String authCode;

    private String parentAuthCode;

    private String createBy;

    private Date gmtCreate;

    private String  lastModifiedBy;

    private Date gmtModified;

    private int sortNo;

    private int isDeleted;

    private int version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public String getMenuComments() {
        return menuComments;
    }

    public void setMenuComments(String menuComments) {
        this.menuComments = menuComments;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getParentAuthCode() {
        return parentAuthCode;
    }

    public void setParentAuthCode(String parentAuthCode) {
        this.parentAuthCode = parentAuthCode;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
