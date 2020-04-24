package com.beatshadow.springcloud.service;

import com.beatshadow.springcloud.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/4/24 13:55
 */
@Component      //没有添加@Component 可能出现java.lang.IllegalStateException: Service id not legal hostname (CLOUD_PROVIDER_PAYMENT)
@FeignClient("cloud-provider-payment")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/test/feign-timeout")
    public CommonResult testFeignTimeout();
}
