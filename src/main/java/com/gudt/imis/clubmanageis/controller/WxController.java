package com.gudt.imis.clubmanageis.controller;

import com.gudt.imis.clubmanageis.model.result.Result;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : WxController
 * @Description : 微信小程序控制类
 * @Author : WDD
 * @Date: 2020-12-18 16:51
 */
@RestController
public class WxController {
    public Result wxAuthorization(@RequestParam("code")String code){

    }
}
