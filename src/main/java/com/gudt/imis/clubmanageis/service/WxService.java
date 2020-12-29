package com.gudt.imis.clubmanageis.service;

import com.gudt.imis.clubmanageis.model.result.Result;

/**
 * @ClassName : WxService
 * @Description :
 * @Author : WDD
 * @Date: 2020-12-18 21:18
 */
public interface WxService {
    Result WxLogin(String code);
    Result wxRegister(Integer userId,String userNick,String userAvatar);
}
