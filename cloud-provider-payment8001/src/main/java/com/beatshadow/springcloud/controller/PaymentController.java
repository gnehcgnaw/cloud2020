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
@SuppressWarnings("unchecked")
@Slf4j
@RestController
public class PaymentController {
    private PaymentService paymentService ;

    @Value("${server.port}")
    private String serverPort ;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.insert(payment);
        log.info("插入结果：{}",result);
        if (result>0){
            return  new CommonResult(200,"数据插入成功，serverPort is "+serverPort,result);
        }else {
            return new CommonResult(444,"数据插入失败，serverPort is "+serverPort);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.selectByPrimaryKey(id);
        log.info("查询结果：{}",payment);
        if (payment!=null){
            return new CommonResult(200,"查询成功，serverPort is "+serverPort,payment);
        }else {
            return new CommonResult(444,"查询失败，serverPort is "+serverPort);
        }
    }

    @GetMapping("/payment/test/feign-timeout")
    public CommonResult testFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(6);
            return new CommonResult(200,"test feign timeout,serverPort is "+serverPort);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null ;
    }
}
