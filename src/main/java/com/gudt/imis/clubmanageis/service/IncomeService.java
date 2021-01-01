package com.gudt.imis.clubmanageis.service;

import com.gudt.imis.clubmanageis.model.entity.ClubIncome;
import com.gudt.imis.clubmanageis.model.result.Result;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName: IncomeService
 * @Author: ccjmlkj
 * @Description:
 * @create: 2020-12-18 22:24
 **/
@Service
public interface IncomeService {
    Result<List<ClubIncome>> getIncomeList(Integer clubId);

    Result<BigDecimal> getTotalIncome(Integer clubId);

    Result<String> createIncome(String incomeTag, Integer clubId, Integer userId, BigDecimal incomeAmount, String incomeReason);
}
