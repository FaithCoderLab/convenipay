package com.zerobase.convenipay.service;

import com.zerobase.convenipay.type.MoneyUseCancelResult;
import com.zerobase.convenipay.type.MoneyUseResult;

public class MoneyAdapter {
    public MoneyUseResult use(Integer amount) {
        System.out.println("MoneyAdapter.use: " + amount);

        if (amount > 1_000_000) {
            return MoneyUseResult.USE_FAIL;
        }

        return MoneyUseResult.USE_SUCCESS;
    }

    public MoneyUseCancelResult useCancel(Integer payCancelAmount) {
        System.out.println("MoneyAdapter.useCancel: " + payCancelAmount);

        if (payCancelAmount < 100) {
            return MoneyUseCancelResult.MONEY_USE_CANCEL_FAILED;
        }

        return MoneyUseCancelResult.MONEY_USE_CANCEL_SUCCESS;
    }
}
