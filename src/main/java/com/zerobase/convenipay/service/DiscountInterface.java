package com.zerobase.convenipay.service;

import com.zerobase.convenipay.dto.PayRequest;

public interface DiscountInterface {
    Integer getDiscountedAmount(PayRequest payRequest);
}
