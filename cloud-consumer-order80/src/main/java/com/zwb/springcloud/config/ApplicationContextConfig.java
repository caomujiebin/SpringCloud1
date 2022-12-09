package com.zwb.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableEurekaClient
public class ApplicationContextConfig {

    //往容器中添加一个RestTemplate
    //RestTemplate提供了多种便捷访问远程http访问的方法
    @Bean
    //@LoadBalanced
    //@LoadBalanced   //赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
