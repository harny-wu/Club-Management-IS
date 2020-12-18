package com.gudt.imis.clubmanageis.model.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户自我介绍
     */
    private String userSelfDescription;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 用户手机
     */
    private String userPhone;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 微信授权需要的一个id
     */
    private String userOpenId;

    private static final long serialVersionUID = 1L;
}