package com.gudt.imis.clubmanageis.service;

import com.gudt.imis.clubmanageis.model.entity.ClubIncome;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: IncomeService
 * @Author: ccjmlkj
 * @Description:
 * @create: 2020-12-18 22:24
 **/
@Service
public interface IncomeService {
    List<ClubIncome> getIncomeList(Integer clubId);

    int getTotalIncome(Integer clubId);
}
