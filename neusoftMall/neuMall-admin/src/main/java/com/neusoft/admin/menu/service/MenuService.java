package com.neusoft.admin.menu.service;

import com.neusoft.admin.menu.entity.Menu;
import com.neusoft.admin.menu.entity.Tree;
import com.neusoft.common.response.AppResponse;


import java.util.Map;

public interface MenuService {
    /**
     * 部门：南京软件研发中心
     * 功能：查询全部菜单
     * 作成者：xywang
     * 作成时间：2019/4/8
     */
    public Tree listMenus();
    /**
     * 部门：南京软件研发中心
     * 功能：删除菜单
     * 描述：略
     * 作成者：xywang
     * 作成时间：2019/4/8
     */
    public void deleteMenu(Menu menu);

    /**
     * 部门：南京软件研发中心
     * 功能：新增菜单
     * 描述：略
     * 作成者：xywang
     * 作成时间：2019/4/8
     */
    public AppResponse insertMenu(Menu menu);

    /**
     * 部门：南京软件研发中心
     * 功能：修改菜单
     * 描述：略
     * 作成者：xywang
     * 作成时间：2019/4/8
     */
    public AppResponse updateMenu(Menu menu);

    /**
     * 部门：南京软件研发中心
     * 功能：查询用户菜单
     * 描述：略
     * 作成者：xywang
     * 作成时间：2019/4/8
     *  public Tree listUserMenus(String userCode, String authCode);
     */

}
