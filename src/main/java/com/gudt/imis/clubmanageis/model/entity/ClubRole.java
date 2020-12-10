package com.gudt.imis.clubmanageis.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * club_role
 * @wdy
 */
@Data
public class ClubRole implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 社团id
     */
    private String clubId;

    /**
     * 用户在这个社团的权限，枚举：（0：管理员，1：记账员 2：普通成员）
     */
    private Integer userRole;

    /**
     * 用户别名
     */
    private String userAlias;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}