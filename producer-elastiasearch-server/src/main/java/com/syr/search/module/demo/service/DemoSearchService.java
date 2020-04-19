package com.syr.search.module.demo.service;

import com.syr.buildIndex.entity.DemoEntity;
import com.syr.module.demo.entity.Demo;
import com.syr.search.module.demo.vo.DemoSearchParam;

import java.util.List;

public interface DemoSearchService {
    List<DemoEntity> list(DemoSearchParam pmsSearchParam);
}
