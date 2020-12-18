package com.gudt.imis.clubmanageis.service.impl;

import com.gudt.imis.clubmanageis.model.entity.Club;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.service.ClubService;
import com.gudt.imis.clubmanageis.util.ResultUtil;
import org.springframework.stereotype.Service;

/**
 * @ClassName : ClubServiceImpl
 * @Description :
 * @Author : WDD
 * @Date: 2020-12-18 16:10
 */
@Service
public class ClubServiceImpl implements ClubService {

    @Override
    public Result createClub() {
        return ResultUtil.success(new Club());
    }
}
