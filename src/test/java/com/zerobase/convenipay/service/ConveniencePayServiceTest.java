package com.zerobase.convenipay.service;

import com.zerobase.convenipay.dto.ConvenienceType;
import com.zerobase.convenipay.dto.PayRequest;
import com.zerobase.convenipay.dto.PayResponse;
import com.zerobase.convenipay.dto.PayResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConveniencePayServiceTest {
    ConveniencePayService conveniencePayService = new ConveniencePayService();

    @Test
    void pay_success() {
        // given
        PayRequest payRequest = new PayRequest(ConvenienceType.GS25, 100);

        // when
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        // then
        assertEquals(PayResult.SUCCESS, payResponse.getPayResult());
        assertEquals(100, payResponse.getPaidAmount());
    }
}