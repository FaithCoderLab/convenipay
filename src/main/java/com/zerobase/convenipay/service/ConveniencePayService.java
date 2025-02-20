package com.zerobase.convenipay.service;

import com.zerobase.convenipay.dto.PayCancelRequest;
import com.zerobase.convenipay.dto.PayCancelResponse;
import com.zerobase.convenipay.dto.PayRequest;
import com.zerobase.convenipay.dto.PayResponse;
import com.zerobase.convenipay.type.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConveniencePayService {    // 편결이
    private final Map<PayMethodType, PaymentInterface> paymentInterfaceMap =
            new HashMap<>();
    private final DiscountInterface discountInterface;

    public ConveniencePayService(
            Set<PaymentInterface> paymentInterfaceSet,
                                 DiscountInterface discountInterface) {
        paymentInterfaceSet.forEach(paymentInterface ->
                paymentInterfaceMap.put(
                paymentInterface.getPayMethodType(), paymentInterface
        ));
        this.discountInterface = discountInterface;
    }

    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap
                .get(payRequest.getPayMethodType());

        Integer discountedAmount = discountInterface.getDiscountedAmount(payRequest);
        PaymentResult payment = paymentInterface.payment(discountedAmount);

        if (payment == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, payRequest.getPayAmount());
        }
        return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap
                .get(payCancelRequest.getPayMethodType());

        PaymentCancelResult paymentCancelResult = paymentInterface
                .cancelPayment(payCancelRequest.getPayCancelAmount());

        if (paymentCancelResult == PaymentCancelResult.PAYMENT_CANCEL_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAILED,
                    payCancelRequest.getPayCancelAmount());
        }

        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());
    }
}
