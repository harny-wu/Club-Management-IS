package com.gudt.imis.clubmanageis.controller;

import com.gudt.imis.clubmanageis.model.entity.Club;
import com.gudt.imis.clubmanageis.model.entity.User;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.model.vo.UserClubRoleVo;
import com.gudt.imis.clubmanageis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName : UserController
 * @Description : 用户控制类
 * @Author : WDD
 * @Date: 2020-12-18 16:51
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/getUserClubs")
    public Result<List<Club>> getUserClubs(@RequestParam("userId") int userId){
        return userService.getUserClubs(userId);
    };

//    @RequestMapping("/updateUserInfo")
//    public Result<User> updateUserInfo(@RequestParam("user")User user){
//        return userService.updateUserInfo(user);
//    };

    @RequestMapping("/updateUserAvatar")
    public Result<String> updateUserAvatar(@RequestParam("userId")int userId, @RequestParam("uploadImg")MultipartFile uploadImg){
        return userService.updateUserAvatar(userId,uploadImg);
    }

    @RequestMapping("/getUserClubAndRole")
    public Result<UserClubRoleVo> getUserClubAndRole(@RequestParam("userId")int userId, @RequestParam("clubId")int clubId){
        return userService.getUserClubAndRole(userId,clubId);
    }
}
