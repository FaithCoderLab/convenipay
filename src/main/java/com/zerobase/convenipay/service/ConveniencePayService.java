package com.zerobase.convenipay.service;

import com.zerobase.convenipay.dto.PayCancelRequest;
import com.zerobase.convenipay.dto.PayCancelResponse;
import com.zerobase.convenipay.dto.PayRequest;
import com.zerobase.convenipay.dto.PayResponse;
import com.zerobase.convenipay.type.MoneyUseResult;
import com.zerobase.convenipay.type.PayResult;

public class ConveniencePayService {    // 편결이
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();

    public PayResponse pay(PayRequest payRequest) {
        MoneyUseResult moneyUseResult = moneyAdapter.use(payRequest.getPayAmount());

        // fail fast

        // Method()

        // Exception case1
        // Exception case2
        // Exception case3
        if (moneyUseResult == MoneyUseResult.USE_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }

        // Success Case(Only one)
        return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
    }
}
