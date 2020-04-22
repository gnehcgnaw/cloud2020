package com.beatshadow.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/4/22 16:24
 */
@Configuration
public class CustomConfiguration {
    @Bean
    public IRule iRule(){
        //随机
        return new RandomRule();
    }
}
