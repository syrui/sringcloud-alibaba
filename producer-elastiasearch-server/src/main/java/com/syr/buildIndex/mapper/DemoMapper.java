package com.syr.buildIndex.mapper;


import com.syr.buildIndex.entity.DemoEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoMapper extends ElasticsearchRepository<DemoEntity, Long> {

}
