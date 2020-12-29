package com.gudt.imis.clubmanageis.controller;

import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : WxController
 * @Description : 微信小程序控制类
 * @Author : WDD
 * @Date: 2020-12-18 16:51
 */
@RestController
public class WxController {
    @Autowired
    WxService wxService;
    @GetMapping("/wxlogin")
    public Result wxAuthorization(@RequestParam("code")String code){
        System.out.println(code);
        return wxService.WxLogin(code);
    }
    @PostMapping("/wxRegister")
    public Result wxRegister(@RequestParam("userId")Integer userId,
                             @RequestParam("userNick")String userNick,
                             @RequestParam("userAvatar")String userAvatar){
        System.out.println(userNick);
        return wxService.wxRegister(userId,userNick,userAvatar);
    }
}
