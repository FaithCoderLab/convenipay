package com.zerobase.convenipay.service;

import com.zerobase.convenipay.dto.PayCancelRequest;
import com.zerobase.convenipay.dto.PayCancelResponse;
import com.zerobase.convenipay.dto.PayRequest;
import com.zerobase.convenipay.dto.PayResponse;
import com.zerobase.convenipay.type.*;

public class ConveniencePayService {    // 편결이
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    private final CardAdapter cardAdapter = new CardAdapter();
    private final PointAdapter pointAdapter = new PointAdapter();
    private final DiscountInterface discountInterface = new DiscountByPayMethod();

    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface;

        if (payRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else if (payRequest.getPayMethodType() == PayMethodType.POINT) {
            paymentInterface = pointAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

        Integer discountedAmount = discountInterface.getDiscountedAmount(payRequest);
        PaymentResult payment = paymentInterface.payment(discountedAmount);

        if (payment == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, payRequest.getPayAmount());
        }
        return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface;

        if (payCancelRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

        PaymentCancelResult paymentCancelResult = paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());

        if (paymentCancelResult == PaymentCancelResult.PAYMENT_CANCEL_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAILED, payCancelRequest.getPayCancelAmount());
        }

        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
    }
}
