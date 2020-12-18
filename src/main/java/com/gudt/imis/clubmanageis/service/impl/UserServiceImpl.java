package com.gudt.imis.clubmanageis.service.impl;

import com.gudt.imis.clubmanageis.model.entity.Club;
import com.gudt.imis.clubmanageis.model.entity.User;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : UserServiceImpl
 * @Description : 用户服务类
 * @Author : WDD
 * @Date: 2020-12-18 20:48
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public Result<List<Club>> getUserClubs(int userId) {
        return null;
    }

    @Override
    public Result<User> updateUserInfo(User user) {
        return null;
    }
}
