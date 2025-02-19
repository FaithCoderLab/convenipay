package com.zerobase.convenipay.service;

import com.zerobase.convenipay.dto.PayRequest;

public class DiscountByPayMethod implements DiscountInterface {

    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        switch (payRequest.getPayMethodType()) {
            case MONEY -> {
                return payRequest.getPayAmount() * 7 / 10;
            }
            case POINT -> {
                return payRequest.getPayAmount();
            }
            case CARD -> {
                return payRequest.getPayAmount() * 9 / 10;
            }
        }
        return payRequest.getPayAmount();
    }
}
