package com.syr.buildIndex.processor.module.demo;

import com.syr.buildIndex.mapper.DemoMapper;
import com.syr.buildIndex.processor.BaseIndexProcesser;
import com.syr.buildIndex.provider.demo.DemoIndexProvider;
import com.syr.module.base.search.IIndexProvider;
import com.syr.module.base.search.ISearchEntity;
import com.syr.module.base.search.SysIndexObjectTypeCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author syr
 * @Description
 * @create 2020-03-11 19:23
 **/
@Component
public class DemoIndexProcesser extends BaseIndexProcesser {


    @Autowired
    DemoIndexProvider demoIndexProvider;

    @Resource
    DemoMapper demoMapper;


    @Override
    public ElasticsearchRepository getElasticsearchRepository() {
        return demoMapper;
    }



    @Override
    public IIndexProvider<? extends ISearchEntity> getProvider() {
        return demoIndexProvider;
    }

    @Override
    public SysIndexObjectTypeCodeEnum getObjectTypeCode() {
        return SysIndexObjectTypeCodeEnum.DEMO;
    }
}
