package com.gudt.imis.clubmanageis.dao;

import com.gudt.imis.clubmanageis.model.entity.ClubTag;

public interface ClubTagDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ClubTag record);

    int insertSelective(ClubTag record);

    ClubTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClubTag record);

    int updateByPrimaryKey(ClubTag record);
}