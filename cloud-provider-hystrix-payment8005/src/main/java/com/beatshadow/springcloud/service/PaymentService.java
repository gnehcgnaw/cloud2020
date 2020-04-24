package com.beatshadow.springcloud.service;

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
    public String paymentInfo_Timeout(Integer id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName()+"...paymentInfo_Timeout"+"...OK .";
    }

}
