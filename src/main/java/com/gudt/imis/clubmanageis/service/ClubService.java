package com.gudt.imis.clubmanageis.service;

import com.gudt.imis.clubmanageis.model.entity.Club;
import com.gudt.imis.clubmanageis.model.result.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName : ClubService
 * @Description :
 * @Author : WDD
 * @Date: 2020-12-18 16:09
 */
public interface ClubService{
    Result<Club> createClub(Club club,int userId);
    Result<Club>joinClubByUserId(int userId,String inviteCode);
    Result<String>updateInviteCode(int clubId,int userId);
    Result<String>updateClubAvatar(int userId, MultipartFile uploadImg);
}
