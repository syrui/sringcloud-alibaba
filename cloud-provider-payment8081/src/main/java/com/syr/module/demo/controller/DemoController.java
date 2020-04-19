package com.syr.module.demo.controller;



import com.syr.module.base.result.BaseProvider;
import com.syr.module.demo.entity.Demo;
import com.syr.module.demo.feign.DemoFeignService;
import com.syr.module.demo.service.DemoService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DemoController extends BaseProvider {
    @Autowired
    DemoService demoService;
    @Autowired
    RedissonClient redissonClient;
    @Resource
    private DemoFeignService demoFeignService;
    @RequestMapping("/getById/{id}")
    public Object domeById(@PathVariable("id") Long id){
        Demo demo = demoService.findById(id);
        return handleSuccess(demo);
    }


    @RequestMapping("/openFeign")
    public Object openFeign(Long id){

        return demoFeignService.domeById(id);
    }

}
