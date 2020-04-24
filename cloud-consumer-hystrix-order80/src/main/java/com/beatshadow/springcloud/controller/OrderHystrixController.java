package com.beatshadow.springcloud.controller;

import com.beatshadow.springcloud.common.CommonResult;
import com.beatshadow.springcloud.service.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/4/24 20:38
 */
@Slf4j
@RestController
@RequestMapping("/hystrix")
public class OrderHystrixController {
    private OrderFeignService orderFeignService ;

    public OrderHystrixController(OrderFeignService orderFeignService) {
        this.orderFeignService = orderFeignService;
    }

    @GetMapping("/payment-info/ok/{id}")
    public CommonResult paymentInfo_OK(@PathVariable("id") Integer id){
        return orderFeignService.paymentInfo_OK(id);
    }
    @GetMapping("/payment-info/timeout/{id}")
    public CommonResult paymentInfo_Timeout(@PathVariable("id") Integer id){
        return orderFeignService.paymentInfo_Timeout(id);
    }

}
