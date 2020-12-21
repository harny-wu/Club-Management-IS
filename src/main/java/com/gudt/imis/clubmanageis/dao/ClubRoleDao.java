package com.gudt.imis.clubmanageis.dao;

import com.gudt.imis.clubmanageis.model.entity.ClubRole;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface ClubRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ClubRole record);

    int insertSelective(ClubRole record);

    ClubRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClubRole record);

    int updateByPrimaryKey(ClubRole record);

    ClubRole selectByUserIdAndClubId(Integer userId,Integer clubId);

    List<ClubRole>selectByUserId(Integer userId);
}