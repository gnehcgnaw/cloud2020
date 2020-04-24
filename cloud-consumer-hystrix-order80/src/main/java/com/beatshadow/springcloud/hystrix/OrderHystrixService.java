package com.beatshadow.springcloud.hystrix;

import com.beatshadow.springcloud.common.CommonResult;
import com.beatshadow.springcloud.service.OrderFeignService;
import org.springframework.stereotype.Component;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/4/25 02:44
 */
@Component
public class OrderHystrixService  implements OrderFeignService {
    @Override
    public CommonResult paymentInfo_OK(Integer id) {
       return new CommonResult(200,"consumer fallback ",null);
    }

    @Override
    public CommonResult paymentInfo_Timeout(Integer id) {
        return new CommonResult(200,"consumer fallback ",null);
    }
}
