package com.gudt.imis.clubmanageis.controller;

import com.gudt.imis.clubmanageis.model.entity.Club;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.service.ClubService;
import com.gudt.imis.clubmanageis.util.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName : ClubController
 * @Description : 社团控制层
 * @Author : WDD
 * @Date: 2020-12-18 16:09
 */
@RestController
public class ClubController {
    @Autowired
    ClubService clubService;

    @GetMapping("/createClub")
    public Result<Club> createClub(@RequestParam("clubName") String clubName,
                             @RequestParam("clubDescription") String clubDescription,
                             @RequestParam("userId") int userId) {
        Club club = Club.ClubBuilder.aClub().
                withClubName(clubName).
                withClubDescription(clubDescription).
                build();
        return clubService.createClub(club,userId);
    }

    @GetMapping("/joinClubByUserId")
    Result<Club>joinClubByUserId(@RequestParam("userId")int userId,@RequestParam("inviteCode")String inviteCode){
        return clubService.joinClubByUserId(userId,inviteCode);
    };
    @GetMapping("/updateInviteCode")
    Result<String>updateInviteCode(@RequestParam("clubId")int clubId,@RequestParam("userId")int userId){
        return clubService.updateInviteCode(clubId,userId);
    };
    @PostMapping("/updateClubAvatar")
    Result<String>updateClubAvatar(@RequestParam("userId")int userId,
                                   @RequestParam("clubId")int clubId,
                                   @RequestParam("uploadImg")MultipartFile uploadImg){
        return clubService.updateClubAvatar(userId,clubId,uploadImg);
    };
}
