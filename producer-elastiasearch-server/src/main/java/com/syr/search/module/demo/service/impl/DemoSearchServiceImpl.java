package com.syr.search.module.demo.service.impl;

import com.syr.buildIndex.entity.DemoEntity;
import com.syr.buildIndex.mapper.DemoMapper;
import com.syr.module.base.search.SysIndexObjectTypeCodeEnum;
import com.syr.module.demo.entity.Demo;
import com.syr.search.module.demo.service.DemoSearchService;
import com.syr.search.module.demo.vo.DemoSearchParam;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.search.aggregation.TermsAggregation;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class DemoSearchServiceImpl implements DemoSearchService {
    @Autowired
    DemoMapper demoMapper;
    @Autowired
    JestClient jestClient;


    @Override
    public List<DemoEntity> list(DemoSearchParam pmsSearchParam) {

        String dslStr = getSearchDsl(pmsSearchParam);
        System.out.println(dslStr);
        Search search = new Search.Builder(dslStr).addIndex(SysIndexObjectTypeCodeEnum.DEMO.getIndex()).addType(SysIndexObjectTypeCodeEnum.DEMO.getType()).build();
        SearchResult execute = null;
        List<DemoEntity> demos = new ArrayList<>();
        try {
            execute = jestClient.execute(search);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<TermsAggregation.Entry> nameAgg =
                execute.getAggregations().getTermsAggregation("bounds").getBuckets();
        for (TermsAggregation.Entry entry:nameAgg){
            System.out.print(entry.getKey()+",");

        }

        List<SearchResult.Hit<DemoEntity, Void>> hits = execute.getHits(DemoEntity.class);
        for (SearchResult.Hit<DemoEntity, Void> hit : hits) {
            DemoEntity source = hit.source;

            Map<String, List<String>> highlight = hit.highlight;
            if(highlight!=null){
                String skuName = highlight.get("skuName").get(0);
                source.setSkuName(skuName);
            }
            demos.add(source);
        }

        return demos;
    }
    private String getSearchDsl(DemoSearchParam pmsSearchParam) {

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();

        if(pmsSearchParam.getCatalog3Id()!=null){
            TermQueryBuilder termQueryBuilder = new TermQueryBuilder(Demo.CATALOG3_ID,pmsSearchParam.getCatalog3Id());
            boolQueryBuilder.filter(termQueryBuilder);
        }

        if(StringUtils.isNotBlank(pmsSearchParam.getSkuName())){
            MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder(Demo.SKU_NAME+".keyword",pmsSearchParam.getSkuName());
            boolQueryBuilder.must(matchQueryBuilder);
        }

        if(pmsSearchParam.getBound()!=null){
            TermQueryBuilder termQueryBuilder = new TermQueryBuilder("bounds",pmsSearchParam.getBound());
            boolQueryBuilder.filter(termQueryBuilder);
        }

        searchSourceBuilder.query(boolQueryBuilder);
        // highlight
        HighlightBuilder highlight = searchSourceBuilder.highlight();
        highlight.preTags("<span style='color:red;'>");
        highlight.field(Demo.SKU_NAME);
        highlight.postTags("</span>");
        // sort
        searchSourceBuilder.sort(Demo.PRODUCT_ID, SortOrder.DESC);
        searchSourceBuilder.from(pmsSearchParam.getPage());
        searchSourceBuilder.size(pmsSearchParam.getSize());

        TermsAggregationBuilder aggregationBuilder = AggregationBuilders.terms("bounds").field("bounds");
        searchSourceBuilder.aggregation(aggregationBuilder);
        return  searchSourceBuilder.toString();
    }

}
