package com.neusoft.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: linmeng
 * @Description:
 * @Date: Create in 15:09 2019/4/23
 */
@Data
public class UserInfo implements Serializable {
    private String userUuid;
    private String userAccount;
    private String userName;
    private String userPwd;
    private String userIdNumber;
    private String tokenBackend; //用户token
}
