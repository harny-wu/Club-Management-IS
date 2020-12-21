package com.gudt.imis.clubmanageis.service.impl;

import com.gudt.imis.clubmanageis.dao.ClubIncomeDao;
import com.gudt.imis.clubmanageis.dao.ClubRoleDao;
import com.gudt.imis.clubmanageis.model.entity.ClubIncome;
import com.gudt.imis.clubmanageis.model.entity.ClubRole;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.service.IncomeService;
import com.gudt.imis.clubmanageis.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: IncomeServiceImpl
 * @Author: ccjmlkj
 * @Description:
 * @create: 2020-12-18 22:25
 **/
@Service
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    private ClubIncomeDao clubIncomeDao;
    @Autowired
    private ClubRoleDao clubRoleDao;
    @Override
    public List<ClubIncome> getIncomeList(Integer clubId) {
        List<ClubIncome> clubIncomeList = clubIncomeDao.getIncomeList(clubId);
        return clubIncomeList;
    }

    @Override
    public int getTotalIncome(Integer clubId) {
        int totalIncome = 0;
        List<ClubIncome> clubIncomeList = clubIncomeDao.getIncomeList(clubId);
        for (ClubIncome clubIncome:clubIncomeList){
            totalIncome = totalIncome + clubIncome.getIncomeAmount().intValue();
        }
        return totalIncome;
    }

    @Override
    public Result<String> createIncome(String incomeTag, Integer clubId, Integer userId, BigDecimal incomeAmount, String incomeReason) {
        Integer userRole = clubRoleDao.selectByUserIdAndClubId(userId,clubId).getUserRole();
        if (userRole == 0 && userRole == 1){
            ClubIncome clubIncome = new ClubIncome();
            clubIncome.setClubId(clubId);
            clubIncome.setUserId(userId);
            clubIncome.setIncomeTags(incomeTag);
            clubIncome.setIncomeAmount(incomeAmount);
            clubIncome.setIncomeReason(incomeReason);
            clubIncome.setIncomeProof("默认没有");
            clubIncome.setCreateTime(new Date());
            clubIncome.setUpdateTime(new Date());
            clubIncomeDao.insert(clubIncome);
            return ResultUtil.success("success");
        }else {
            return ResultUtil.error(405,"error");
        }
    }


}
