package com.gudt.imis.clubmanageis.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * club_income
 * @author 
 */
@Data
public class ClubIncome implements Serializable {
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
     * 收入标签
     */
    private String incomeTags;

    /**
     * 收入时间
     */
    private Date incomeTime;

    /**
     * 收入凭证，图片路径
     */
    private String incomeProof;

    /**
     * 收入原因
     */
    private String incomeReason;

    /**
     * 收入金额
     */
    private BigDecimal incomeAmount;

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