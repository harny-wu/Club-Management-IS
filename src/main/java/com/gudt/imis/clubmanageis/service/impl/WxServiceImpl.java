package com.gudt.imis.clubmanageis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gudt.imis.clubmanageis.config.WxConfig;
import com.gudt.imis.clubmanageis.constant.WxConstant;
import com.gudt.imis.clubmanageis.dao.UserDao;
import com.gudt.imis.clubmanageis.model.entity.User;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.service.WxService;
import com.gudt.imis.clubmanageis.util.ResultUtil;
import com.gudt.imis.clubmanageis.util.https.HttpsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : WxServiceImpl
 * @Description :
 * @Author : WDD
 * @Date: 2020-12-18 21:18
 */
@Service
@Slf4j
public class WxServiceImpl implements WxService {
    @Autowired
    UserDao userDao;
    @Override
    public Result<User> WxLogin(String code) {
        Map<String,Object>params = WxConstant.getWechatLoginFixedParameterset();
        params.put("js_code",code);
        JSONObject response = HttpsUtils.GET(WxConfig.CODE2SESSIONURL,params);
        log.info(response.toJSONString());
        String openId=response.getString("openid");
        User user=userDao.selectByOpenId(openId);
        if (user==null){
            user=User.UserBuilder.anUser().withUserOpenId(openId).build();
            userDao.insertSelective(user);
            return ResultUtil.success(user);
        }else{
            return ResultUtil.success(user);
        }
    }
}
