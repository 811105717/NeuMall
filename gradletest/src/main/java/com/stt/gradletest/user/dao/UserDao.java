package com.stt.gradletest.user.dao;

import com.stt.gradletest.user.model.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component("UserDao")
public interface UserDao {
    Map<String,Object> getUserList();

    List<Map<String, Object>> getUserListById(Map<String, Object> param);

    List<UserVo> getUserListByModel();
}
