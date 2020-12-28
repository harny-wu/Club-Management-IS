package com.gudt.imis.clubmanageis.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * club_pay
 * @author 
 */
@Data
public class ClubPay implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 社团id
     */
    private Integer clubId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 支出标签
     */
    private String payTags;

    /**
     * 支出时间
     */
    private Date payTime;

    /**
     * 支出凭证，图片路径
     */
    private String payProof;

    /**
     * 支出原因
     */
    private String payReason;

    /**
     * 支出金额
     */
    private BigDecimal payAmount;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户昵称
     */
    private String userName;

    private static final long serialVersionUID = 1L;
}