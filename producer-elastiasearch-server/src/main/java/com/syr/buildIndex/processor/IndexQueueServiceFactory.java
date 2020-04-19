package com.syr.buildIndex.processor;


import com.syr.dao.module.core.service.IndexQueueService;
import com.syr.module.base.result.BusinessException;
import com.syr.module.base.search.IIndexProvider;
import com.syr.module.base.search.ISearchEntity;
import com.syr.module.base.search.SysIndexObjectTypeCodeEnum;
import com.syr.module.core.entity.SysIndexQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  服务层实现
 * @author by imall core generator
 * @version 1.0.0
 */

@Service
public class IndexQueueServiceFactory {
    private static Logger logger = LoggerFactory.getLogger(IndexQueueServiceFactory.class);

    @Autowired
    private IndexQueueService indexQueueService;

    final private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 10*60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(20));

    public void buildIndexTimer(final ElasticsearchRepository elasticsearchRepository, final IIndexProvider<? extends ISearchEntity> provider, final SysIndexObjectTypeCodeEnum core) throws BusinessException {
        //如果队列放满了20个就不要再执行了
        if(executor.getQueue().size()>5||elasticsearchRepository==null){
            return;
        }

        final List<SysIndexQueue> sysIndexQueues = indexQueueService.findByIndexEum(core);

        if (CollectionUtils.isEmpty(sysIndexQueues)) {
            return;
        }
        ArrayList<Long> ids = new ArrayList<>();
        for (SysIndexQueue sysIndexQueue : sysIndexQueues){
            ids.add(sysIndexQueue.getSysObjectId());
            indexQueueService.delById(sysIndexQueue.getSysIndexQueueId());
        }

        executor.execute(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                commit(ids,provider,core,elasticsearchRepository);
                if (ids.size() > 0) {
                    logger.info("成功建立"+core+"索引数据，size=" + ids.size() +" MILLISECONDS="+(System.currentTimeMillis()-start));
                }
            }
        });

    }


    public  void commit(final List<Long> ids, IIndexProvider provider, SysIndexObjectTypeCodeEnum core,ElasticsearchRepository elasticsearchRepository) throws BusinessException { //NOSONAR

        for (final Long id : ids) {
            ISearchEntity providerEntity =null;
            try {
                 providerEntity = provider.getEntity(id);


            if (providerEntity == null) {
                elasticsearchRepository.deleteById(id);
            } else {
                elasticsearchRepository.save(providerEntity);
            }
            }catch (Exception e){
                e.printStackTrace();
            }

        }


    }


}