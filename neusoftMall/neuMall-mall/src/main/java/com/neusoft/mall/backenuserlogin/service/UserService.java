package com.neusoft.mall.backenuserlogin.service;

import com.neusoft.common.entity.UserInfo;
import com.neusoft.common.response.AppResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @Author: linmeng
 * @Description:
 * @Date: Create in 15:26 2019/4/23
 */

public interface UserService {
        AppResponse userLongin(UserInfo userInfo, HttpServletRequest request) throws UnsupportedEncodingException;
}
