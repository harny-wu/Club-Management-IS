package com.gudt.imis.clubmanageis.service.impl;

import com.gudt.imis.clubmanageis.dao.ClubPayDao;
import com.gudt.imis.clubmanageis.dao.ClubRoleDao;
import com.gudt.imis.clubmanageis.model.entity.ClubPay;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.service.PayService;
import com.gudt.imis.clubmanageis.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
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
    @Autowired
    private ClubRoleDao clubRoleDao;
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

    @Override
    public Result<String> createPay(Integer clubId, Integer userId, String payTag, BigDecimal payAmount, String payReason) {
        Integer userRole = clubRoleDao.selectByUserIdAndClubId(clubId,userId).getUserRole();
        if (userRole == 0 && userRole == 1){
            ClubPay clubPay = new ClubPay();
            clubPay.setClubId(clubId);
            clubPay.setUserId(userId);
            clubPay.setPayTags(payTag);
            clubPay.setPayAmount(payAmount);
            clubPay.setPayReason(payReason);
            clubPay.setPayProof("默认没有");
            clubPay.setUpdateTime(new Date());
            clubPay.setCreateTime(new Date());
            clubPayDao.insert(clubPay);
            return ResultUtil.success("success");
        }else {
            return ResultUtil.error(405,"error");
        }

    }
}
