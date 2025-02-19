package com.zerobase.convenipay.service;

import com.zerobase.convenipay.type.PaymentCancelResult;
import com.zerobase.convenipay.type.PaymentResult;

public interface PaymentInterface {
    PaymentResult payment(Integer payAmount);
    PaymentCancelResult cancelPayment(Integer cancelAmount);
}
