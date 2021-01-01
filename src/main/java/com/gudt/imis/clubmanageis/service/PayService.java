package com.gudt.imis.clubmanageis.service;

import com.gudt.imis.clubmanageis.model.entity.ClubPay;
import com.gudt.imis.clubmanageis.model.result.Result;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName: PayService
 * @Author: ccjmlkj
 * @Description:
 * @create: 2020-12-18 20:25
 **/
@Service
public interface PayService {
    Result<List<ClubPay>> getPayList(Integer clubId);

    Result<BigDecimal> getTotalPay(Integer clubId);

    Result<String> createPay(Integer clubId, Integer userId, String payTag, BigDecimal payAmount, String payReason);
}
