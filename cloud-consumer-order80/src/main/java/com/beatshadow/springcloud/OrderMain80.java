package com.beatshadow.springcloud;

import com.beatshadow.config.CustomConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/4/20 23:54
 */
@Slf4j
/*@RibbonClients({
        //  调用那个服务，使用什么规则
   @RibbonClient(name = "cloud-provider-payment" , configuration = CustomConfiguration.class)
})*/
@EnableDiscoveryClient
@MapperScan(basePackages = "com.beatshadow.springcloud.mapper")
@SpringBootApplication
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }

    @RestController
    class OrderMain80Controller{
        private DiscoveryClient discoveryClient ;

        public OrderMain80Controller(DiscoveryClient discoveryClient) {
            this.discoveryClient = discoveryClient;
        }

        @GetMapping("/discovery")
        public void discovery(){
            discoveryClient.getServices().forEach(s -> {
                log.info("服务名称：{}",s);
            });

            discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT").forEach(serviceInstance -> {
                log.info("当前服务的节点信息：{},{},{}", serviceInstance.getHost(),serviceInstance.getInstanceId(),serviceInstance.getMetadata());
            });
        }
    }
}
