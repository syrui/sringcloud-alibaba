package com.syr.module.user.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.syr.module.BaseEntityManager;
import com.syr.module.base.eum.ErrorCode;
import com.syr.module.base.result.BusinessException;
import com.syr.module.user.mapper.UmsMemberMapper;
import com.syr.module.user.entity.UmsMember;
import com.syr.module.user.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 会员表 服务层实现
 * @author by imall core generator
 * @version 1.0.0
 */

@Service
public class   UmsMemberServiceImpl  extends BaseEntityManager<UmsMember,Long>  implements  UmsMemberService{

    @Autowired
     UmsMemberMapper  umsMemberMapper;

    @Override
    protected BaseMapper<UmsMember> getEntityDao() {
        return umsMemberMapper;
        }

    @Override
    protected String clearRedisCacheKeys() {
        return null;
      }

    @Override
    public List<UmsMember> getAll() {
        return umsMemberMapper.selectList(Wrappers.<UmsMember>lambdaQuery().ge(UmsMember::getId,1));
    }
}