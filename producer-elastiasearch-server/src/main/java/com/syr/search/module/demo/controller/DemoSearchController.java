package com.syr.search.module.demo.controller;

import com.syr.module.base.result.BaseProvider;
import com.syr.search.module.demo.service.DemoSearchService;
import com.syr.search.module.demo.vo.DemoSearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoSearchController extends BaseProvider {

    @Autowired
    private DemoSearchService demoSearchService;

    @RequestMapping("testSearch")
    private Object testSearch(String skuName,Integer size,Integer page,Long catalog3Id,Integer bound){
        DemoSearchParam searchParam = new DemoSearchParam();
        searchParam.setSize(size);
        searchParam.setPage(page);
        searchParam.setSkuName(skuName);
        searchParam.setCatalog3Id(catalog3Id);
        searchParam.setBound(bound);
        return handleSuccess(demoSearchService.list(searchParam));
    }

}
