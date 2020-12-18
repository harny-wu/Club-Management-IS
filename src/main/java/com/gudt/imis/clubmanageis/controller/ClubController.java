package com.gudt.imis.clubmanageis.controller;

import com.gudt.imis.clubmanageis.model.entity.Club;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.service.ClubService;
import com.gudt.imis.clubmanageis.util.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
