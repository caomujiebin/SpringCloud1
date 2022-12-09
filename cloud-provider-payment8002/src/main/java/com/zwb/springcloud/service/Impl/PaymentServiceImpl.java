package com.zwb.springcloud.service.Impl;

import com.zwb.springcloud.service.PaymentService;
import com.zwb.springcloud.dao.PaymentDao;
import com.zwb.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.selectById(id);
    }
}
