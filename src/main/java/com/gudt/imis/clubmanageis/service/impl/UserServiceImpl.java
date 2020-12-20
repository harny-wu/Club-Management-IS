package com.gudt.imis.clubmanageis.service.impl;

import com.gudt.imis.clubmanageis.dao.ClubDao;
import com.gudt.imis.clubmanageis.dao.ClubRoleDao;
import com.gudt.imis.clubmanageis.dao.UserDao;
import com.gudt.imis.clubmanageis.model.entity.Club;
import com.gudt.imis.clubmanageis.model.entity.ClubRole;
import com.gudt.imis.clubmanageis.model.entity.User;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.model.vo.UserClubRoleVo;
import com.gudt.imis.clubmanageis.service.UserService;
import com.gudt.imis.clubmanageis.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : UserServiceImpl
 * @Description : 用户服务类
 * @Author : WDD
 * @Date: 2020-12-18 20:48
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    ClubRoleDao clubRoleDao;
    @Autowired
    ClubDao clubDao;

    @Override
    @Transactional
    public Result<List<Club>> getUserClubs(int userId) {
        List<ClubRole>clubRoles=clubRoleDao.selectByUserId(userId);
        List<Club>clubs=new ArrayList<>();
        for (ClubRole clubRole: clubRoles){
            clubs.add(clubDao.selectByPrimaryKey(clubRole.getClubId()));
        }
        return ResultUtil.success(clubs);
    }

    @Override
    @Transactional
    public Result<User> updateUserInfo(User user) {
        userDao.updateByPrimaryKeySelective(user);
        return ResultUtil.success(userDao.selectByPrimaryKey(user.getId()));

    }

    @Override
    public Result<String> updateUserAvatar(int userId, MultipartFile uploadImg) {
        return null;
    }

    @Override
    @Transactional
    public Result<UserClubRoleVo> getUserClubAndRole(int userId,int clubId) {
        User user=userDao.selectByPrimaryKey(userId);
        Club club=clubDao.selectByPrimaryKey(clubId);
        ClubRole clubRole=clubRoleDao.selectByUserIdAndClubId(userId,clubId);
        UserClubRoleVo userClubRoleVo=UserClubRoleVo.getUserClubRoleVo(user,club,clubRole);
        return ResultUtil.success(userClubRoleVo);

    }
}
