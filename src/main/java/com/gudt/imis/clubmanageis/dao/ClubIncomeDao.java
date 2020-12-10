package com.gudt.imis.clubmanageis.dao;

import com.gudt.imis.clubmanageis.model.entity.ClubIncome;

public interface ClubIncomeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ClubIncome record);

    int insertSelective(ClubIncome record);

    ClubIncome selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClubIncome record);

    int updateByPrimaryKey(ClubIncome record);
}