package com.gudt.imis.clubmanageis.controller;

import com.gudt.imis.clubmanageis.model.entity.ClubPay;
import com.gudt.imis.clubmanageis.model.result.Result;
import com.gudt.imis.clubmanageis.service.PayService;
import com.gudt.imis.clubmanageis.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
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
        return payService.getPayList(clubId);
    }
    @GetMapping(value = "/getTotalPay")
    public Result<Integer> getTotalPay(@RequestParam("clubId")Integer clubId){
        return payService.getTotalPay(clubId);
    }
    @PostMapping("/createPay")
    public Result<String> createPay(@RequestParam("clubId")Integer clubId,
                            @RequestParam("userId")Integer userId,
                            @RequestParam("payTag")String payTag,
                            @RequestParam("payAmount")BigDecimal payAmount,
                            @RequestParam("payReason")String payReason){
        return payService.createPay(clubId,userId,payTag,payAmount,payReason);
    }
}
