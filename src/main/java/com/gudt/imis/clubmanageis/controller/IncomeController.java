package com.gudt.imis.clubmanageis.controller;

import com.gudt.imis.clubmanageis.model.entity.ClubIncome;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.service.IncomeService;
import com.gudt.imis.clubmanageis.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName: IncomeController
 * @Author: ccjmlkj
 * @Description:
 * @create: 2020-12-18 22:15
 **/
@RestController
public class IncomeController {
    @Autowired
    private IncomeService incomeService;
    @GetMapping(value = "/getIncomeList")
    public Result<List<ClubIncome>> getIncomeList(@RequestParam("clubId")Integer clubId){
        return incomeService.getIncomeList(clubId);
    }
    @GetMapping(value = "/getTotalIncome")
    public Result<Integer> getTotalIncome(@RequestParam("clubId")Integer clubId){
        return incomeService.getTotalIncome(clubId);
    }
    @PostMapping(value = "/createIncome")
    public Result<String> createIncome(@RequestParam("incomeTag")String incomeTag,
                                       @RequestParam("clubId")Integer clubId,
                                       @RequestParam("userId")Integer userId,
                                       @RequestParam("incomeAmount")BigDecimal incomeAmount,
                                       @RequestParam("incomeReason")String incomeReason) {
        return incomeService.createIncome(incomeTag,clubId,userId,incomeAmount,incomeReason);

    }
}
