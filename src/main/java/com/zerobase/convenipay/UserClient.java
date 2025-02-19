package com.zerobase.convenipay;

import com.zerobase.convenipay.config.ApplicationConfig;
import com.zerobase.convenipay.dto.PayCancelRequest;
import com.zerobase.convenipay.dto.PayCancelResponse;
import com.zerobase.convenipay.dto.PayRequest;
import com.zerobase.convenipay.dto.PayResponse;
import com.zerobase.convenipay.service.ConveniencePayService;
import com.zerobase.convenipay.service.DiscountInterface;
import com.zerobase.convenipay.type.ConvenienceType;
import com.zerobase.convenipay.type.PayMethodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserClient {
    public static void main(String[] args) {
        // 사용자 -> 편결이 -> 머니
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        ConveniencePayService conveniencePayService =
                applicationContext.getBean(
                        "conveniencePayService",
                        ConveniencePayService.class
                );

        // 결제 1000원
        PayRequest payRequest = new PayRequest(
                ConvenienceType.GS25,
                1_000,
                PayMethodType.MONEY);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse.toString());

        // 취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(
                ConvenienceType.GS25,
                500,
                PayMethodType.MONEY);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelResponse.toString());
    }
}
