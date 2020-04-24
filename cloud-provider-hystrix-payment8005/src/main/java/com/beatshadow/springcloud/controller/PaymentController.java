package com.beatshadow.springcloud.controller;

import com.beatshadow.springcloud.common.CommonResult;
import com.beatshadow.springcloud.entity.Payment;
import com.beatshadow.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/4/21 04:36
 */
@Slf4j
@RestController
public class PaymentController {
    private PaymentService paymentService ;

    @Value("${server.port}")
    private String serverPort ;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/hystrix/payment-info/ok/{id}")
    public CommonResult paymentInfo_OK(@PathVariable("id") Integer id){
        log.info("paymentInfo_OK execute");
        return new CommonResult(200,"成功",paymentService.paymentInfo_Ok(id)+"...serverPort"+serverPort);
    }

    @GetMapping("/hystrix/payment-info/timeout/{id}")
    public CommonResult paymentInfo_Timeout(@PathVariable("id") Integer id){
        log.info("paymentInfo_Timeout execute");
        return new CommonResult(200,"成功",paymentService.paymentInfo_Timeout(id)+"...serverPort"+serverPort);
    }

}
