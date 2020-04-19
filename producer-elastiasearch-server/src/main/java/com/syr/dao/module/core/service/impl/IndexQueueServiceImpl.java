package com.syr.dao.module.core.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.syr.dao.module.core.mapper.IndexQueueMapper;
import com.syr.dao.module.core.service.IndexQueueService;
import com.syr.module.BaseEntityManager;
import com.syr.module.base.search.SysIndexObjectTypeCodeEnum;

import com.syr.module.core.entity.SysIndexQueue;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  服务层实现
 * @author by imall core generator
 * @version 1.0.0
 */

@Service
public class IndexQueueServiceImpl extends BaseEntityManager<SysIndexQueue,Long> implements IndexQueueService {

    @Autowired
    IndexQueueMapper indexQueueMapper;

    @Override
    public List<SysIndexQueue> findByIndexEum(SysIndexObjectTypeCodeEnum sysIndexObjectTypeCodeEnum) {
        Page<SysIndexQueue> pageBean = new Page<>(0 ,1000);
        Page<SysIndexQueue> indexQueuePage = indexQueueMapper.selectPage(pageBean,
                Wrappers.<SysIndexQueue>lambdaQuery().eq(SysIndexQueue::getSysIndexObjectTypeCode, sysIndexObjectTypeCodeEnum.name()));
        return indexQueuePage.getRecords();
    }

    @Override
    @Transactional
    public void delById(Long id) {
        indexQueueMapper.delete(Wrappers.<SysIndexQueue>lambdaQuery().eq(SysIndexQueue::getSysIndexQueueId,id));
    }


    @Override
    protected BaseMapper<SysIndexQueue> getEntityDao() {
        return indexQueueMapper;
    }

    @Override
    protected String clearRedisCacheKeys() {
        return null;
    }
}