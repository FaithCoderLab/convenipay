package com.zerobase.convenipay.service;

import com.zerobase.convenipay.type.PaymentCancelResult;
import com.zerobase.convenipay.type.PaymentResult;

public class PointAdapter implements PaymentInterface {
    @Override
    public PaymentResult payment(Integer payAmount) {
        return null;
    }

    @Override
    public PaymentCancelResult cancelPayment(Integer cancelAmount) {
        return null;
    }
}
