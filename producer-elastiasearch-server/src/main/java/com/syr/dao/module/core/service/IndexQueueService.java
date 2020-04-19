package com.syr.dao.module.core.service;



import com.syr.module.base.search.SysIndexObjectTypeCodeEnum;
import com.syr.module.core.entity.SysIndexQueue;

import java.util.List;

/**
 *  服务层实现
 * @author by imall core generator
 * @version 1.0.0
 */

public interface IndexQueueService {

    List<SysIndexQueue> findByIndexEum(SysIndexObjectTypeCodeEnum sysIndexObjectTypeCodeEnum);

    void delById(Long id);
}