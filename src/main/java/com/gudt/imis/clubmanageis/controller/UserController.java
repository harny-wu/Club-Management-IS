package com.gudt.imis.clubmanageis.controller;

import com.gudt.imis.clubmanageis.model.entity.Club;
import com.gudt.imis.clubmanageis.model.entity.User;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.model.vo.UserClubRoleVo;
import com.gudt.imis.clubmanageis.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName : UserController
 * @Description : 用户控制类
 * @Author : WDD
 * @Date: 2020-12-18 16:51
 */
@RestController
@Api(value = "用户操作ApI")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getUserClubs")
    @ApiOperation(value = "查询该用户所在的所有社团的信息")
    public Result<List<Club>> getUserClubs(@RequestParam("userId") int userId){
        return userService.getUserClubs(userId);
    };

    @PostMapping("/updateUserInfo")
    public Result<User> updateUserInfo(User user){
        return userService.updateUserInfo(user);
    };

    @PostMapping("/updateUserAvatar")
    public Result<String> updateUserAvatar(@RequestParam("userId")int userId, @RequestParam("uploadImg")MultipartFile uploadImg){
        return userService.updateUserAvatar(userId,uploadImg);
    }

    @GetMapping("/getUserClubAndRole")
    public Result<UserClubRoleVo> getUserClubAndRole(@RequestParam("userId")int userId, @RequestParam("clubId")int clubId){
        return userService.getUserClubAndRole(userId,clubId);
    }

    @PostMapping("/updateUserClubRole")
    public Result<String> updateUserClubRole(@RequestParam("userId1")int userId1,
                                             @RequestParam("userId2")int userId2,
                                             @RequestParam("clubId")int clubId,
                                             @RequestParam("role")int role) {
        return userService.updateUserClubRole(userId1,userId2,clubId,role);
    }

    @GetMapping("/getClubAllUsers")
    public Result<List<UserClubRoleVo>>getClubAllUsers(@RequestParam("clubId")int clubId){
        return userService.getAllUserByClubId(clubId);
    }

    @GetMapping("/getInviteCode")
    public Result<String>getInviteCode(@RequestParam("userId")int userId,@RequestParam("clubId")int clubId){
        return userService.getInviteCode(userId,clubId);
    }
}
