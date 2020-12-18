package com.gudt.imis.clubmanageis.dao;

import com.gudt.imis.clubmanageis.model.entity.ClubIncome;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubIncomeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ClubIncome record);

    int insertSelective(ClubIncome record);

    ClubIncome selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClubIncome record);

    int updateByPrimaryKey(ClubIncome record);

    List<ClubIncome> getIncomeList(Integer clubId);
}