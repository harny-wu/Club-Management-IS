package com.gudt.imis.clubmanageis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gudt.imis.clubmanageis.config.WxConfig;
import com.gudt.imis.clubmanageis.constant.WxConstant;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.service.WxService;
import com.gudt.imis.clubmanageis.util.ResultUtil;
import com.gudt.imis.clubmanageis.util.https.HttpsUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : WxServiceImpl
 * @Description :
 * @Author : WDD
 * @Date: 2020-12-18 21:18
 */
public class WxServiceImpl implements WxService {
    @Override
    public Result WxLogin(String code) {
        Map<String,Object>params = WxConfig.getWechatLoginFixedParameterset();
        params.put("js_code",code);
        JSONObject response = HttpsUtils.GET(WxConfig.CODE2SESSIONURL,params);
        return ResultUtil.success(response);
    }
}
