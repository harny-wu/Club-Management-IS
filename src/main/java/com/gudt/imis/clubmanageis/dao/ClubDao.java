package com.gudt.imis.clubmanageis.dao;

import com.gudt.imis.clubmanageis.model.entity.Club;

public interface ClubDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Club record);

    int insertSelective(Club record);

    Club selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Club record);

    int updateByPrimaryKey(Club record);
}