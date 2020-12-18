package com.gudt.imis.clubmanageis.controller;

import com.gudt.imis.clubmanageis.model.entity.ClubIncome;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.service.IncomeService;
import com.gudt.imis.clubmanageis.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping(value = "getIncomeList")
    public Result getIncomeList(@RequestParam("clubId")Integer clubId){
        List<ClubIncome> clubIncomeList = incomeService.getIncomeList(clubId);
        return ResultUtil.success(clubIncomeList);
    }
    @GetMapping(value = "getTotalIncome")
    public Result getTotalIncome(@RequestParam("clubId")Integer clubId){
        int totalIncome = incomeService.getTotalIncome(clubId);
        return ResultUtil.success(totalIncome);
    }
}
