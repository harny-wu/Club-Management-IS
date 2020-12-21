package com.gudt.imis.clubmanageis.controller;

import com.gudt.imis.clubmanageis.model.entity.ClubPay;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.service.PayService;
import com.gudt.imis.clubmanageis.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: PayController
 * @Author: ccjmlkj
 * @Description:
 * @create: 2020-12-18 22:15
 **/
@RestController
public class PayController {
    @Autowired
    private PayService payService;
    @GetMapping(value = "/getPayList")
    public Result<List<ClubPay>> getPayList(@RequestParam("clubId")Integer clubId){
        List<ClubPay> clubPayList = payService.getPayList(clubId);
        return ResultUtil.success(clubPayList);
    }
    @GetMapping(value = "/getTotalPay")
    public Result<Integer> getTotalPay(@RequestParam("clubId")Integer clubId){
        int totalPay = payService.getTotalPay(clubId);
        return ResultUtil.success(totalPay);
    }
}
