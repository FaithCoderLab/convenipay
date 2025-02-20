package com.zerobase.convenipay.service;

import com.zerobase.convenipay.type.*;

public class CardAdapter implements PaymentInterface {
    // 1. 인증
    public void authorization() {
        System.out.println("authorization success");
    }

    // 2. 승인
    public void approval() {
        System.out.println("approval success");
    }

    // 3. 매입
    public CardUseResult capture(Integer payAmount) {
        if (payAmount > 100) {
            return CardUseResult.USE_FAIL;
        }

        return CardUseResult.USE_SUCCESS;
    }

    // 4. 매입 취소
    public CardUseCancelResult cancelCapture(Integer cancelAmount) {
        if (cancelAmount < 1_000) {
            return CardUseCancelResult.USE_CANCEL_FAIL;
        }

        return CardUseCancelResult.USE_CANCEL_SUCCESS;
    }

    @Override
    public PayMethodType getPayMethodType() {
        return null;
    }

    @Override
    public PaymentResult payment(Integer payAmount) {
        authorization();
        approval();
        CardUseResult cardUseResult = capture(payAmount);

        if (cardUseResult == CardUseResult.USE_FAIL) {
            return PaymentResult.PAYMENT_FAIL;
        }

        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public PaymentCancelResult cancelPayment(Integer cancelAmount) {
        CardUseCancelResult cardUseCancelResult = cancelCapture(cancelAmount);
        if (cardUseCancelResult == CardUseCancelResult.USE_CANCEL_FAIL) {
            return PaymentCancelResult.PAYMENT_CANCEL_FAIL;
        }
        return PaymentCancelResult.PAYMENT_CANCEL_SUCCESS;
    }
}
