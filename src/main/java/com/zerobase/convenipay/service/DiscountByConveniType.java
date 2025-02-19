package com.zerobase.convenipay.service;

import com.zerobase.convenipay.dto.PayRequest;

public class DiscountByConveniType implements DiscountInterface {
    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        switch (payRequest.getConvenienceType()) {
            case GS25 -> {
                return payRequest.getPayAmount() * 8 / 10;
            }
            case CU -> {
                return payRequest.getPayAmount() * 9 / 10;
            }
            case SEVEN_ELEVEN -> {
                return payRequest.getPayAmount();
            }
        }
        return payRequest.getPayAmount();
    }
}
