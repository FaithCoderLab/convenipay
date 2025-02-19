package com.zerobase.convenipay.dto;

import com.zerobase.convenipay.type.ConvenienceType;
import com.zerobase.convenipay.type.PayMethodType;

public class PayCancelRequest {
    // 결제 수단
    PayMethodType payMethodType;

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }

    // 편의점 종류
    ConvenienceType convenienceType;

    // 결제 취소 금액
    Integer payCancelAmount;

    public PayCancelRequest(ConvenienceType convenienceType, Integer payCancelAmount, PayMethodType payMethodType) {
        this.convenienceType = convenienceType;
        this.payCancelAmount = payCancelAmount;
        this.payMethodType = payMethodType;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayCancelAmount() {
        return payCancelAmount;
    }

    public void setPayCancelAmount(Integer payCancelAmount) {
        this.payCancelAmount = payCancelAmount;
    }
}
