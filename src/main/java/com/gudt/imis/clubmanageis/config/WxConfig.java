package com.gudt.imis.clubmanageis.config;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : WxConfig
 * @Description :
 * @Author : WDD
 * @Date: 2020-12-18 22:59
 */
@Configuration
public class WxConfig {
    public static final String CODE2SESSIONURL="https://api.weixin.qq.com/sns/jscode2session";
    public static final String APPID="";
    public static final String SECRET="";
    public static final String GRANTTYPE="authorization_code";

    public static Map<String,Object> getWechatLoginFixedParameterset(){
        Map<String,Object>wechatLoginFixedParameterset=new HashMap<>();
        wechatLoginFixedParameterset.put("appid",APPID);
        wechatLoginFixedParameterset.put("secret",SECRET);
        wechatLoginFixedParameterset.put("grant_type",GRANTTYPE);
        return wechatLoginFixedParameterset;
    }

}
