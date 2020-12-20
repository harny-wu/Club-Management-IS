package com.gudt.imis.clubmanageis.model.vo;

import com.gudt.imis.clubmanageis.model.entity.Club;
import com.gudt.imis.clubmanageis.model.entity.ClubRole;
import com.gudt.imis.clubmanageis.model.entity.User;
import lombok.Data;

/**
 * @ClassName : UserClubRoleVo
 * @Description : 用户在某个社团的信息
 * @Author : WDD
 * @Date: 2020-12-20 16:27
 */
@Data
public class UserClubRoleVo {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户自我介绍
     */
    private String userSelfDescription;


    /**
     * 用户手机
     */
    private String userPhone;

    /**
     * 用户邮箱
     */
    private String userEmail;


    /**
     * 社团ID
     */
    private Integer clubId;

    /**
     * 社团简介
     */
    private String clubDescription;

    /**
     * 社团名字
     */
    private String clubName;

    /**
     * 列表存储[img1,img2….]社团首页展示图片
     */
    private String clubImgs;


    /**
     * 用户在这个社团的权限，枚举：（0：管理员，1：记账员 2：普通成员）
     */
    private Integer userRole;

    /**
     * 用户别名
     */
    private String userAlias;

    public static UserClubRoleVo getUserClubRoleVo(User user, Club club, ClubRole clubRole){
        UserClubRoleVo userclubRoleVo=new UserClubRoleVo();
        userclubRoleVo.setUserId(user.getId());
        userclubRoleVo.setUserName(user.getUserName());
        userclubRoleVo.setUserPhone(user.getUserPhone());
        userclubRoleVo.setUserEmail(user.getUserEmail());
        userclubRoleVo.setUserSelfDescription(user.getUserSelfDescription());
        userclubRoleVo.setUserRole(clubRole.getUserRole());
        userclubRoleVo.setUserAlias(clubRole.getUserAlias());
        userclubRoleVo.setClubId(club.getId());
        userclubRoleVo.setClubName(club.getClubName());
        userclubRoleVo.setClubDescription(club.getClubDescription());
        userclubRoleVo.setClubImgs(club.getClubImgs());
        return userclubRoleVo;
    }
}
