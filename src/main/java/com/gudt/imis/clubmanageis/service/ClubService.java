package com.gudt.imis.clubmanageis.service;

import com.gudt.imis.clubmanageis.model.entity.Club;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.model.vo.UserClubRoleVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName : ClubService
 * @Description :
 * @Author : WDD
 * @Date: 2020-12-18 16:09
 */
public interface ClubService{
    Result<Club> createClub(Club club,int userId);
    Result<Club>joinClubByUserId(int userId,String inviteCode);
    Result<List<UserClubRoleVo>>getClubAllUser(int clubId);
    Result<String>updateInviteCode(int clubId,int userId);
    Result<String>updateClubAvatar(int userId,int clubId, MultipartFile uploadImg);
}
