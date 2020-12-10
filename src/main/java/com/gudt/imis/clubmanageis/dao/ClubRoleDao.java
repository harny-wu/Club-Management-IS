package com.gudt.imis.clubmanageis.dao;

import com.gudt.imis.clubmanageis.model.entity.ClubRole;

public interface ClubRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ClubRole record);

    int insertSelective(ClubRole record);

    ClubRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClubRole record);

    int updateByPrimaryKey(ClubRole record);
}