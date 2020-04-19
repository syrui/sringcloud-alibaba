package com.syr.module.demo.service.impl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.syr.module.BaseEntityManager;
import com.syr.module.base.eum.ErrorCode;
import com.syr.module.base.result.BusinessException;
import com.syr.module.demo.mapper.DemoMapper;
import com.syr.module.demo.entity.Demo;
import com.syr.module.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 库存单元表 服务层实现
 * @author by imall core generator
 * @version 1.0.0
 */

@Service
public class   DemoServiceImpl extends BaseEntityManager<Demo,Long> implements DemoService {

    @Autowired
    DemoMapper demoMapper;

    @Override
    public Demo findById(Long demoId) {
        Demo demo = demoMapper.selectById(demoId);
        if(demo==null){
            throw  new BusinessException(ErrorCode.SYS_VALIDATION_ERROR);
        }
        return demo;
    }

    @Override
    protected BaseMapper<Demo> getEntityDao() {
        return demoMapper;
    }

    @Override
    protected String clearRedisCacheKeys() {
        return "demo:id-";
    }
}