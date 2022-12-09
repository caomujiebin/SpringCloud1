package com.zwb.springcloud.controller;

import com.zwb.springcloud.service.PaymentService;
import com.zwb.springcloud.entities.CommonResult;
import com.zwb.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if(result>0){
            return new CommonResult(200,"插入成功",result);
        }else return new CommonResult(444,"插入失败",null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        if(result != null){
            return new CommonResult(200,"查询成功,端口号是"+serverPort,result);
        }else return new CommonResult(444,"查询失败",null);
    }
}
