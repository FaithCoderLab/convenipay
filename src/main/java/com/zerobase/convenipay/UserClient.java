package com.zerobase.convenipay;

import com.zerobase.convenipay.dto.PayCancelRequest;
import com.zerobase.convenipay.dto.PayCancelResponse;
import com.zerobase.convenipay.dto.PayRequest;
import com.zerobase.convenipay.dto.PayResponse;
import com.zerobase.convenipay.service.ConveniencePayService;
import com.zerobase.convenipay.type.ConvenienceType;

public class UserClient {
    public static void main(String[] args) {
        // 사용자 -> 편결이 -> 머니
        ConveniencePayService conveniencePayService = new ConveniencePayService();

        // 결제 1000원
        PayRequest payRequest = new PayRequest(ConvenienceType.GS25, 1_000);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse.toString());

        // 취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(ConvenienceType.GS25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelResponse.toString());
    }
}
