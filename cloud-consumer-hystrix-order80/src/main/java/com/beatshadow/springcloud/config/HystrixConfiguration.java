package com.beatshadow.springcloud.config;

import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.netflix.hystrix.HystrixCircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/4/25 03:49
 */
@Configuration
public class HystrixConfiguration {
    @Bean
    public Customizer<HystrixCircuitBreakerFactory> customizer(){
        return hystrixCircuitBreakerFactory -> hystrixCircuitBreakerFactory.configure(hystrixConfigBuilder -> {
            HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(1000);
        },"paymentInfo_OK","paymentInfo_Timeout");
    }
}
