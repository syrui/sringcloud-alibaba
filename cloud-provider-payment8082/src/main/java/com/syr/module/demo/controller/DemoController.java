package com.syr.module.demo.controller;

import com.syr.module.base.result.BaseProvider;
import com.syr.module.demo.entity.Demo;
import com.syr.module.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController  extends BaseProvider {
    @Autowired
    DemoService demoService;


    @RequestMapping("/getById/{id}")
    public Object domeById(@PathVariable("id") Long id){
        Demo demo = demoService.findById(id);
        return handleSuccess(demo);
    }
    @RequestMapping("/test/{id}")
    public Object test(@PathVariable("id") Long id){
        Demo demo = demoService.findById(id);
        return handleSuccess(demo); }
}
