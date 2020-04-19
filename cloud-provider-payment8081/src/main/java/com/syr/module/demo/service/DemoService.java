package com.syr.module.demo.service;

import com.syr.module.demo.entity.Demo;

/**
 * 库存单元表 服务层实现
 * @author by imall core generator
 * @version 1.0.0
 */

public interface  DemoService{
    Demo findById(Long demoId);
}