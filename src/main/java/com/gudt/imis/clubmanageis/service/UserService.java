package com.gudt.imis.clubmanageis.service;

import com.gudt.imis.clubmanageis.model.entity.Club;
import com.gudt.imis.clubmanageis.model.entity.User;
import com.gudt.imis.clubmanageis.model.result.Result;

import java.util.List;

public interface UserService {
    Result<List<Club>>getUserClubs(int userId);
    Result<User>updateUserInfo(User user);
}
