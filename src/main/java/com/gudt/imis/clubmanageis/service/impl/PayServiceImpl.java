package com.gudt.imis.clubmanageis.service.impl;

import com.gudt.imis.clubmanageis.dao.ClubPayDao;
import com.gudt.imis.clubmanageis.model.entity.ClubPay;
import com.gudt.imis.clubmanageis.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: PayServiceImpl
 * @Author: ccjmlkj
 * @Description:
 * @create: 2020-12-19 00:43
 **/
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private ClubPayDao clubPayDao;
    @Override
    public List<ClubPay> getPayList(Integer clubId) {
        List<ClubPay> clubPayList = clubPayDao.getPayList(clubId);
        return clubPayList;
    }

    @Override
    public int getTotalPay(Integer clubId) {
        List<ClubPay> clubPayList = clubPayDao.getPayList(clubId);
        int totalPay = 0;
        for (ClubPay clubPay:clubPayList){
            totalPay = totalPay + clubPay.getPayAmount().intValue();
        }
        return totalPay;
    }
}
