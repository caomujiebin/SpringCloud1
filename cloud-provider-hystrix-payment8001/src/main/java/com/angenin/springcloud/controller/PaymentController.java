package com.angenin.springcloud.controller;

import com.angenin.springcloud.service.PaymentService;
import com.zwb.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")    //spring的@Value注解
    private String ServerPort;

    //================服务降级==================

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("******result：" + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("******result：" + result);
        return result;
    }


    //=================服务熔断====================

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("******result：" + result);
        return result;
    }
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return new CommonResult(200,"查询成功,端口号是"+serverPort+",id="+id);
    }
}
