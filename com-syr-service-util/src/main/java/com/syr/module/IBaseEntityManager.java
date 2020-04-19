package com.syr.module;

import com.baomidou.mybatisplus.core.conditions.Wrapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IBaseEntityManager<E, PK extends Serializable> {

    E getById(PK id) throws Exception;

    void save(E entity) throws Exception;

    void removeById(PK id) throws Exception;


    void update(E entity, Wrapper<E> wrapper) throws Exception;

    List<E> findList(Wrapper<E> wrapper)throws Exception ;

    List<E> findByKey(Map<String, Object> var1);


    void batchSave(List<E> entitys);

    void batchRemove(List<PK> entitys);
}

