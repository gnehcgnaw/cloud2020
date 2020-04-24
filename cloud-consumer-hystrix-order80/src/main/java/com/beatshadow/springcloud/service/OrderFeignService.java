package com.beatshadow.springcloud.service;

import com.beatshadow.springcloud.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/4/24 20:30
 */
@Component
@FeignClient(name = "cloud-provider-hystrix-payment")
public interface OrderFeignService {

    @GetMapping("/hystrix/payment-info/ok/{id}")
    public CommonResult paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/payment-info/timeout/{id}")
    public CommonResult paymentInfo_Timeout(@PathVariable("id") Integer id);
}
