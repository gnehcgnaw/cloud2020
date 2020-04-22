package com.beatshadow.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/4/20 23:54
 */
@EnableDiscoveryClient
@MapperScan(basePackages = "com.beatshadow.springcloud.mapper")
@SpringBootApplication
public class PaymentConsulMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain8004.class,args);
    }

}
