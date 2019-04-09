package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 14:02
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@Data
public class UserInfo extends BaseEntity {
    private String userUuid;//用户代码
    private String userAccount;//用户账号
    private String userName;//用户姓名
    private String userPwd;//密码
    private String userNewPwd;//新密码
    private String userIdNumber;//身份证号码
    private String userTel;//手机号码
    private String userGender;//性别
    private String userIsUsed;//是否使用   1使用 0禁用
    private String userEmail;//电子邮件
    private String userComments;//备注
}
