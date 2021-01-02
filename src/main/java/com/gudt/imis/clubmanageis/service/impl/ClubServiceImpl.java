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
import com.gudt.imis.clubmanageis.service.ClubService;
import com.gudt.imis.clubmanageis.util.FileUploadUtil;
import com.gudt.imis.clubmanageis.util.ResultUtil;
import com.gudt.imis.clubmanageis.util.ShareCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    UserDao userDao;
    @Autowired
    ClubRoleDao clubRoleDao;

    @Override
    @Transactional
    //todo:加一个功能限制用户创建社团数量的功能
    public Result<Club> createClub(Club club, int userId) {
        //插入社团信息,获得社团主键
        if (clubDao.insertSelective(club) > 0) {
            ClubRole clubRole = ClubRole.ClubRoleBuilder.aClubRole()
                    .withClubId(club.getId())
                    .withUserId(userId)
                    .withUserRole(ClubRoleEnum.MANAGE.getCode()).build();
            //设置创建社团用户为该社团管理员
            clubRoleDao.insertSelective(clubRole);
            //根据社团ID生成邀请码,并更新数据库
            club.setClubInvitecode(ShareCodeUtil.toSerialCode((long) club.getId()));
            clubDao.updateByPrimaryKeySelective(club);
            return ResultUtil.success(club);
        } else {
            return ResultUtil.error(500, "");
        }
    }

    @Override
    @Transactional
    public Result<Club> joinClubByUserId(int userId, String inviteCode) {
        Club club = clubDao.selectByInviteCode(inviteCode);
        ClubRole clubRole=clubRoleDao.selectByUserIdAndClubId(userId,club.getId());
        //判断用户是否已经加入该社团
        if (club!=null){
            if (clubRole == null) {
                ClubRole newclubRole = ClubRole.ClubRoleBuilder.aClubRole()
                        .withUserId(userId)
                        .withClubId(club.getId())
                        .withUserRole(ClubRoleEnum.ORDINARYMEMBER.getCode()).build();
                if (clubRoleDao.insertSelective(newclubRole)>0){
                    return ResultUtil.success(club);
                }else {
                    return ResultUtil.error(500, "");
                }
            } else {
                return ResultUtil.error(400, "你已经在社团内了");
            }
        }else{
            return ResultUtil.error(400, "邀请码错误");
        }

    }

    @Override
    @Transactional
    public Result<List<UserClubRoleVo>> getClubAllUser(int clubId) {
        Club club=clubDao.selectByPrimaryKey(clubId);
        List<ClubRole>clubRoles=clubRoleDao.selectByClubId(clubId);
        List<UserClubRoleVo>userClubRoleVos=new ArrayList<>();
        User user;
        for (ClubRole clubRole : clubRoles){
            user=userDao.selectByPrimaryKey(clubRole.getUserId());
            userClubRoleVos.add(UserClubRoleVo.getUserClubRoleVo(user,club,clubRole));
        }
        return ResultUtil.success(userClubRoleVos);
    }

    @Override
    @Transactional
    public Result<String> updateInviteCode(int clubId, int userId) {
        ClubRole clubRole=clubRoleDao.selectByUserIdAndClubId(userId,clubId);
        if (clubRole!=null&&clubRole.getUserRole()==ClubRoleEnum.MANAGE.getCode()){
            String newInviteCode = ShareCodeUtil.toSerialCode(clubId);
            Club club=clubDao.selectByPrimaryKey(clubId);
            club.setClubInvitecode(newInviteCode);
            clubDao.updateByPrimaryKeySelective(club);
            return ResultUtil.success(newInviteCode);
        }else{
            return ResultUtil.error(400,"邀请码错误");
        }
    }

    @Override
    public Result<String> updateClubAvatar(int userId,int clubId, MultipartFile uploadImg) {
        // 获取文件名
        String fileName = uploadImg.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        List<String> extList = Arrays.asList(".jpg", ".png", ".jpeg", ".gif");
        if (!extList.contains(suffixName)) {
            return ResultUtil.error(400,"图片格式出错");
        }

        ClubRole clubRole=clubRoleDao.selectByUserIdAndClubId(userId,clubId);
        if (clubRole.getUserRole()==ClubRoleEnum.MANAGE.getCode()){
            Club club=clubDao.selectByPrimaryKey(clubId);
            String path= PathConfig.CLUBUPLOADFILEPATH;
            String finalFileName=FileUploadUtil.UploadFile(uploadImg,path);
            if (finalFileName!=null){
                String clubImgUrl=PathConfig.MYURL+PathConfig.CLUBUPLOADPATHMAPPING+finalFileName;
                club.setClubImgs(clubImgUrl);
                clubDao.updateByPrimaryKeySelective(club);
                return ResultUtil.success(clubImgUrl);
            }
            return ResultUtil.error(500,"上传图片失败");
        }else{
            return ResultUtil.error(400,"权限不足");
        }
    }
}
