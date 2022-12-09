package com.angenin.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class fallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "error";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "error";
    }
}
