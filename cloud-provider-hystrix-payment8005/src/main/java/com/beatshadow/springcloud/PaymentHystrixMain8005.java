package com.beatshadow.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/4/20 23:54
 */

@EnableCircuitBreaker   //开启熔断
@EnableEurekaClient
@SpringBootApplication
public class PaymentHystrixMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8005.class,args);
    }

}
