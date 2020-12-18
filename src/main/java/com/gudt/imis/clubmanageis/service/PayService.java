package com.gudt.imis.clubmanageis.service;

import com.gudt.imis.clubmanageis.model.entity.ClubPay;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: PayService
 * @Author: ccjmlkj
 * @Description:
 * @create: 2020-12-18 20:25
 **/
@Service
public interface PayService {
    List<ClubPay> getPayList(Integer clubId);

    int getTotalPay(Integer clubId);
}
