package com.gudt.imis.clubmanageis.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * club_tag
 * @author 
 */
@Data
public class ClubTag implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 社团id
     */
    private Integer clubId;

    /**
     * 标签名字
     */
    private String tagName;

    /**
     * 标签类型：0：公共标签 1：社团私有标签，默认为0
     */
    private Integer tagType;

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