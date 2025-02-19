package com.zerobase.convenipay.service;

import com.zerobase.convenipay.dto.PayRequest;
import com.zerobase.convenipay.type.ConvenienceType;
import com.zerobase.convenipay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByPayMethodTest {
    DiscountByPayMethod discountByPayMethod;

    @Test
    void discountSuccess() {

        // given
        PayRequest moneyPayRequest = new PayRequest(ConvenienceType.GS25,
                1000, PayMethodType.MONEY);
        PayRequest cardPayRequest = new PayRequest(ConvenienceType.CU,
                1000, PayMethodType.CARD);
        PayRequest pointPayRequest = new PayRequest(ConvenienceType.GS25,
                1000, PayMethodType.POINT);

        // when
        Integer discountedAmountMoney = discountByPayMethod
                .getDiscountedAmount(moneyPayRequest);
        Integer discountedAmountCard = discountByPayMethod
                .getDiscountedAmount(cardPayRequest);
        Integer discountedAMountPoint = discountByPayMethod
                .getDiscountedAmount(pointPayRequest);

        // then
        assertEquals(700, discountedAmountMoney);
        assertEquals(900, discountedAmountCard);
        assertEquals(1000, discountedAMountPoint);
    }
}