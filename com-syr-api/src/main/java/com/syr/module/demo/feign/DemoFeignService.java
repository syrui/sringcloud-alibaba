package com.syr.module.demo.feign;

import com.syr.module.base.result.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这是一个声明式的远程调用
 */

@Component
@FeignClient(value = "cloud-payment-service",fallback = DemoFallbackService.class)
public interface DemoFeignService {

    @RequestMapping("/getById/{id}")
    BaseResponse domeById(@PathVariable("id")Long id);

}
