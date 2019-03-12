package com.stt.gradletest.user.service;

import com.stt.gradletest.user.model.UserVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String,Object> getUserList();

    List<Map<String, Object>> getUserListById(Map<String, Object> param);

    List<UserVo> getUserListByModel(UserVo userVo);

    Map<String, String> uploadTest(Map<String, Object> param, HttpServletRequest request);
}
