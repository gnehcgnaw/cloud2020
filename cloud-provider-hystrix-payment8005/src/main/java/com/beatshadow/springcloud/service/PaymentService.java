package com.beatshadow.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/4/21 00:11
 */
@Service
public class PaymentService{

    /**
     * 正常
     * @param id
     * @return
     */
    public String paymentInfo_Ok(Integer id){
        return Thread.currentThread().getName()+"...paymentInfo_Ok"+"...OK .";
    }

    /**
     * 模拟超时
     * @return
     */
    @HystrixCommand(
            //服务降级方法
            fallbackMethod ="paymentInfo_Timeout_fallbackHandler" ,commandProperties = {
            //什么时候进行超时处理
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS,value = "2000")
    })
    public String paymentInfo_Timeout(Integer id){
        //有异常，或者超时都会进行服务降级
        //int count = 10/0 ;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName()+"...paymentInfo_Timeout"+id+"...OK .";
    }

    /**
     * 服务降级方案
     * @param id
     * @return
     */
    public String paymentInfo_Timeout_fallbackHandler(Integer id){
        return Thread.currentThread().getName()+"...paymentInfo_Timeout_fallbackHandler"+id+"...OK .";
    }


}
