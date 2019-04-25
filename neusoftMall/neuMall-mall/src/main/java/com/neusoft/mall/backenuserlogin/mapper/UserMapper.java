package com.neusoft.mall.backenuserlogin.mapper;

import com.neusoft.common.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author: linmeng
 * @Description:
 * @Date: Create in 15:21 2019/4/23
 */
@SuppressWarnings("ALL")
@Mapper
@Component
public interface UserMapper {
UserInfo userLogin(UserInfo userInfo);
}
