package com.gudt.imis.clubmanageis.service;

import com.gudt.imis.clubmanageis.model.entity.Club;
import com.gudt.imis.clubmanageis.model.entity.User;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.model.vo.UserClubRoleVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    Result<List<Club>> getUserClubs(int userId);
    Result<User> updateUserInfo(User user);
    Result<String> updateUserAvatar(int userId, MultipartFile uploadImg);
    Result<UserClubRoleVo> getUserClubAndRole(int userId,int clubId);
    Result<String>updateUserClubRole(int userId1,int userId2,int clubId,int role);
}
