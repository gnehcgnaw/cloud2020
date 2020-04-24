package com.beatshadow.springcloud.controller;

import com.beatshadow.springcloud.common.CommonResult;
import com.beatshadow.springcloud.entity.Payment;
import com.beatshadow.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/4/24 14:08
 */
@Slf4j
@RequestMapping("/consumer")
@RestController
public class OrderFeignController {

    private PaymentFeignService paymentFeignService ;

    public OrderFeignController(PaymentFeignService paymentFeignService) {
        this.paymentFeignService = paymentFeignService;
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        CommonResult commonResult = paymentFeignService.getPaymentById(id);
        log.info("调用Feign成功：{}" ,commonResult);
        return commonResult ;
    }

    @GetMapping("/payment/test/feign-timeout")
    public CommonResult testFeignTimeout(){
        CommonResult commonResult = paymentFeignService.testFeignTimeout();
        return commonResult ;
    }
}
