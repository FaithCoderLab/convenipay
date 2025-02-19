package com.zerobase.convenipay.service;

import com.zerobase.convenipay.dto.PayRequest;
import com.zerobase.convenipay.type.ConvenienceType;
import com.zerobase.convenipay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByConveniTypeTest {
    DiscountByConveniType discountByConveniType = new DiscountByConveniType();

    @Test
    void discountTest() {
        // given
        PayRequest payRequestGS25 = new PayRequest(ConvenienceType.GS25, 1000, PayMethodType.MONEY);
        PayRequest payRequestCU = new PayRequest(ConvenienceType.CU, 1000, PayMethodType.MONEY);
        PayRequest payRequestSEVEN = new PayRequest(ConvenienceType.SEVEN_ELEVEN, 1000, PayMethodType.MONEY);

        // when
        Integer discountedAmountGS25 = discountByConveniType.getDiscountedAmount(payRequestGS25);
        Integer discountedAmountCU = discountByConveniType.getDiscountedAmount(payRequestCU);
        Integer discountedAmountSEVEN = discountByConveniType.getDiscountedAmount(payRequestSEVEN);

        // then
        assertEquals(800, discountedAmountGS25);
        assertEquals(900, discountedAmountCU);
        assertEquals(1000, discountedAmountSEVEN);

    }
}