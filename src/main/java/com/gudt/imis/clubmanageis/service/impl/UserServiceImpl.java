package com.gudt.imis.clubmanageis.service.impl;

import com.gudt.imis.clubmanageis.config.PathConfig;
import com.gudt.imis.clubmanageis.dao.ClubDao;
import com.gudt.imis.clubmanageis.dao.ClubRoleDao;
import com.gudt.imis.clubmanageis.dao.UserDao;
import com.gudt.imis.clubmanageis.model.ClubRoleEnum;
import com.gudt.imis.clubmanageis.model.entity.Club;
import com.gudt.imis.clubmanageis.model.entity.ClubRole;
import com.gudt.imis.clubmanageis.model.entity.User;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.model.vo.UserClubRoleVo;
import com.gudt.imis.clubmanageis.service.UserService;
import com.gudt.imis.clubmanageis.util.FileUploadUtil;
import com.gudt.imis.clubmanageis.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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
        if(user.getId()!=null){
        userDao.updateByPrimaryKeySelective(user);
        return ResultUtil.success(userDao.selectByPrimaryKey(user.getId()));
        }else{
            return ResultUtil.error(405,"用户id为空");
        }

    }

    @Override
    @Transactional
    public Result<String> updateUserAvatar(int userId, MultipartFile uploadImg) {
        // 获取文件名
        String fileName = uploadImg.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        List<String> extList = Arrays.asList(".jpg", ".png", ".jpeg", ".gif");
        if (!extList.contains(suffixName)) {
            return ResultUtil.error(400,"图片格式出错");
        }
        User user=userDao.selectByPrimaryKey(userId);
        if(user!=null){
            String path= PathConfig.USERUPLOADFILEPATH;
            String finalFileName= FileUploadUtil.UploadFile(uploadImg,path);
            if (finalFileName!=null){
                String userImg=PathConfig.MYURL+PathConfig.USERUPLOADPATHMAPPING+finalFileName;
                user.setUserAvatar(finalFileName);
                userDao.updateByPrimaryKeySelective(user);
                return ResultUtil.success(userImg);
            }
            else{
                return ResultUtil.error(500,"上传失败，请重试");
            }
        }else{
            return ResultUtil.error(401,"用户不存在");
        }


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

    @Override
    @Transactional
    public Result<String> updateUserClubRole(int userId1, int userId2, int clubId, int role) {
        ClubRole clubRole1=clubRoleDao.selectByUserIdAndClubId(userId1,clubId);
        if(clubRole1.getUserRole()!= ClubRoleEnum.MANAGE.getCode()){
            return ResultUtil.error(400,"用户权限不足");
        }else {
            ClubRole clubRole2=clubRoleDao.selectByUserIdAndClubId(userId2,clubId);
            clubRole2.setUserRole(role);
            clubRoleDao.updateByPrimaryKeySelective(clubRole2);
            return ResultUtil.success(clubRole2);
        }

    }

    @Override
    @Transactional
    public Result<List<UserClubRoleVo>> getAllUserByClubId(int clubId) {
        List<ClubRole>clubRoles=clubRoleDao.selectByClubId(clubId);
        List<UserClubRoleVo>userClubRoleVoList=new ArrayList<>();
        UserClubRoleVo userClubRoleVoTemp=new UserClubRoleVo();
        Club club=clubDao.selectByPrimaryKey(clubId);
        for(ClubRole clubRole : clubRoles){
            User user=userDao.selectByPrimaryKey(clubRole.getUserId());
            userClubRoleVoTemp=UserClubRoleVo.getUserClubRoleVo(user,club,clubRole);
            userClubRoleVoList.add(userClubRoleVoTemp);
        }
        return ResultUtil.success(userClubRoleVoList);
    }

    @Override
    @Transactional
    public Result<String> getInviteCode(int userId, int clubId) {
        ClubRole clubRole=clubRoleDao.selectByUserIdAndClubId(userId,clubId);
        if (clubRole!=null){
            if (clubRole.getUserRole()==ClubRoleEnum.MANAGE.getCode()){
                Club club=clubDao.selectByPrimaryKey(clubId);
                return ResultUtil.success(club.getClubInvitecode());
            }else{
                return ResultUtil.error(401,"用户权限不足");
            }
        }else{
            return ResultUtil.error(401,"参数错误");
        }
    }
}
