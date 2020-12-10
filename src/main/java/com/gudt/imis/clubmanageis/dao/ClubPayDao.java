package com.gudt.imis.clubmanageis.dao;

import com.gudt.imis.clubmanageis.model.entity.ClubPay;

public interface ClubPayDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ClubPay record);

    int insertSelective(ClubPay record);

    ClubPay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClubPay record);

    int updateByPrimaryKey(ClubPay record);
}