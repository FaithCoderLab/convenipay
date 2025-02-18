package com.zerobase.convenipay.service;

import com.zerobase.convenipay.dto.PayRequest;
import com.zerobase.convenipay.dto.PayResponse;
import com.zerobase.convenipay.dto.PayResult;

public class ConveniencePayService {
    public PayResponse pay(PayRequest payRequest) {
        return new PayResponse(PayResult.SUCCESS, 100);
    }

    public void payCancel() {

    }
}
