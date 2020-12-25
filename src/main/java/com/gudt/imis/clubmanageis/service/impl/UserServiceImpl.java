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
            return ResultUtil.error(301,"userId notnull");
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
            return ResultUtil.error(301,"图片格式出错");
        }
        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName = UUID.randomUUID().toString().replace("-", "") + suffixName;
        // 返回客户端 文件地址 URL
        String url = "localhost:8084"+"/upload/" + fileName;
        File dest = new File( "/springbootProject/club/image" + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            uploadImg.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user=userDao.selectByPrimaryKey(userId);
        user.setUserAvatar(url);
        userDao.updateByPrimaryKeySelective(user);
        return ResultUtil.success(url);

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
        if(clubRole1.getUserRole()!=2){
            return ResultUtil.error(301,"error");
        }else {
            ClubRole clubRole2=clubRoleDao.selectByUserIdAndClubId(userId2,clubId);
            clubRole2.setUserRole(role);
            return ResultUtil.success();
        }

    }


}
