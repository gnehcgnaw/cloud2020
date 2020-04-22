package com.beatshadow.springcloud.controller;

import com.beatshadow.springcloud.common.CommonResult;
import com.beatshadow.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/4/21 05:18
 */
@SuppressWarnings("unchecked")
@Slf4j
@RestController
public class OrderController {
    //standalone private static final String PAYMENT_URL = "http://localhost:8001";

    //zookeeper方式使用小写
    //eureka方式使用大写
    //cluster
    private static final String PAYMENT_URL = "http://cloud-providerconsul-payment";

    private final RestTemplate restTemplate ;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

}
