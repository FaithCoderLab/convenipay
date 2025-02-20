package com.zerobase.convenipay.config;

import com.zerobase.convenipay.service.*;
import com.zerobase.convenipay.type.ConvenienceType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class ApplicationConfig {

    @Bean
    public ConveniencePayService conveniencePayService() {
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(getMoneyAdapter(), getCardAdapter())
                ),
                getDiscountInterface()
        );
    }

    @Bean
    private static CardAdapter getCardAdapter() {
        return new CardAdapter();
    }

    @Bean
    private static MoneyAdapter getMoneyAdapter() {
        return new MoneyAdapter();
    }

    @Bean
    private static DiscountByConveniType getDiscountInterface() {
        return new DiscountByConveniType();
    }
}
