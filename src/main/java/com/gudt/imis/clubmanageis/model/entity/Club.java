package com.gudt.imis.clubmanageis.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * club
 * @wdy
 */
@Data
public class Club implements Serializable {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 社团简介
     */
    private String clubDescription;

    /**
     * 社团名字
     */
    private String clubName;

    /**
     * 列表存储[img1,img2….]社团首页展示图片
     */
    private String clubImgs;

    /**
     * 社团邀请码
     */
    private String clubInvitecode;

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