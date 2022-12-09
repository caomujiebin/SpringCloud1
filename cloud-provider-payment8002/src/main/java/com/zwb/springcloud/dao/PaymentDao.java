package com.zwb.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwb.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao extends BaseMapper<Payment> {
    public int create(Payment payment);

    Payment selectById(Long id);
}
