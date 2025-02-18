package com.zerobase.convenipay.service;

import org.junit.jupiter.api.Test;

import static com.zerobase.convenipay.service.MoneyUseResult.USE_FAIL;
import static com.zerobase.convenipay.service.MoneyUseResult.USE_SUCCESS;
import static org.junit.jupiter.api.Assertions.*;

class MoneyAdapterTest {
    MoneyAdapter moneyAdapter = new MoneyAdapter();

    @Test
    void money_use_fail() {
        // given
        Integer payAmount = 1_000_001;

        // when
        MoneyUseResult moneyUseResult = moneyAdapter.use(payAmount);

        // then
        assertEquals(USE_FAIL, moneyUseResult);
    }

    @Test
    void money_use_success() {
        // given
        Integer payAmount = 1_000_000;

        // when
        MoneyUseResult moneyUseResult = moneyAdapter.use(payAmount);

        // then
        assertEquals(USE_SUCCESS, moneyUseResult);
    }
}