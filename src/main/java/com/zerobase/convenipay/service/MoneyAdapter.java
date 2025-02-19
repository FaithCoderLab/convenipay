package com.zerobase.convenipay.service;

import com.zerobase.convenipay.type.MoneyUseCancelResult;
import com.zerobase.convenipay.type.MoneyUseResult;
import com.zerobase.convenipay.type.PaymentCancelResult;
import com.zerobase.convenipay.type.PaymentResult;

public class MoneyAdapter implements PaymentInterface {
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

    @Override
    public PaymentResult payment(Integer payAmount) {
        MoneyUseResult moneyUseResult = use(payAmount);

        if (moneyUseResult == MoneyUseResult.USE_FAIL) {
            return PaymentResult.PAYMENT_FAIL;
        }

        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public PaymentCancelResult cancelPayment(Integer cancelAmount) {
        MoneyUseCancelResult moneyUseCancelResult = useCancel(cancelAmount);

        if (moneyUseCancelResult == MoneyUseCancelResult.MONEY_USE_CANCEL_FAILED) {
            return PaymentCancelResult.PAYMENT_CANCEL_FAIL;
        }

        return PaymentCancelResult.PAYMENT_CANCEL_SUCCESS;
    }
}
