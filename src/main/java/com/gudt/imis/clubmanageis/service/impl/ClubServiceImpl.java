package com.gudt.imis.clubmanageis.service.impl;

import com.gudt.imis.clubmanageis.dao.ClubDao;
import com.gudt.imis.clubmanageis.dao.ClubRoleDao;
import com.gudt.imis.clubmanageis.model.ClubRoleEnum;
import com.gudt.imis.clubmanageis.model.entity.Club;
import com.gudt.imis.clubmanageis.model.entity.ClubRole;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.service.ClubService;
import com.gudt.imis.clubmanageis.util.ResultUtil;
import com.gudt.imis.clubmanageis.util.ShareCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName : ClubServiceImpl
 * @Description :
 * @Author : WDD
 * @Date: 2020-12-18 16:10
 */
@Service
@Slf4j
public class ClubServiceImpl implements ClubService {

    @Autowired
    ClubDao clubDao;
    @Autowired
    ClubRoleDao clubRoleDao;

    @Override
    public Result<Club> createClub(Club club, int userId) {
        //插入社团信息,获得社团主键
        if (clubDao.insertSelective(club) > 0) {
            ClubRole clubRole = ClubRole.ClubRoleBuilder.
                    aClubRole().
                    withClubId(club.getId()).
                    withUserId(userId).
                    withUserRole(ClubRoleEnum.MANAGE.getCode()).build();
            //设置创建社团用户为该社团管理员
            clubRoleDao.insertSelective(clubRole);
            //根据社团ID生成邀请码,并更新数据库
            club.setClubInvitecode(ShareCodeUtil.toSerialCode((long)club.getId()));
            clubDao.updateByPrimaryKeySelective(club);
            return ResultUtil.success(club);
        } else {
            return ResultUtil.error(301, "please retry");
        }
    }

    @Override
    public Result<Club> joinClubByUserId(int userId, String inviteCode) {
        return null;
    }

    @Override
    public Result<String> updateInviteCode(int clubId, int userId) {
        return null;
    }

    @Override
    public Result<String> updateClubAvatar(int userId, MultipartFile uploadImg) {
        return null;
    }

}
