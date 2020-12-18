package com.gudt.imis.clubmanageis.service.impl;

import com.gudt.imis.clubmanageis.dao.ClubIncomeDao;
import com.gudt.imis.clubmanageis.model.entity.ClubIncome;
import com.gudt.imis.clubmanageis.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
