package com.syr.module;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.syr.module.base.TableId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Transactional(readOnly = true)
public abstract class BaseEntityManager <E,PK extends Serializable> implements IBaseEntityManager<E, PK>{
    @Autowired
    protected RedisTemplate redisTemplate;

    protected abstract BaseMapper<E> getEntityDao();

    /**
     * 是否需要清除redis缓存，缓存key   XXX-id , XXX-id
     * @return
     */
    protected abstract String clearRedisCacheKeys();

    @Transactional(readOnly=true)
    public E getById(PK id) throws Exception {
        return getEntityDao().selectById(id);
    }


    @Transactional
    public void save(E entity) throws Exception{
        if(entity!=null){
            getEntityDao().insert(entity);

        }
    }

    @Transactional(readOnly=true)
    public List<E> findList(Wrapper<E> wrapper) throws Exception {
        return getEntityDao().selectList(wrapper);
    }



  @Transactional(readOnly=true)
    public List<E> findByKey(Map<String, Object> var1) {
        return getEntityDao().selectByMap(var1);
    }





    @Transactional
    public void removeById(PK id) throws Exception {
        getEntityDao().deleteById(id);
        String cacheKeys = clearRedisCacheKeys();
        if(!StringUtils.isEmpty(clearRedisCacheKeys())){
            Arrays.stream(cacheKeys.split(",")).forEach(key->{
                redisTemplate.delete(key.trim()+id);
            });



        }
    }


    @Transactional
    @Override
    public void update(E entity,Wrapper<E> wrapper) {
        getEntityDao().update(entity,wrapper);
        clearRedisCache(entity);
    }


    private void clearRedisCache(Object entity){
        String cacheKeys = clearRedisCacheKeys();
        Field[] fields = entity.getClass().getDeclaredFields();
        Long id =null;

        for (Field field:fields){
            if(field.isAnnotationPresent(TableId.class)){
                field.setAccessible(true); // 私有属性必须设置访问权限
                try {
                    id =(Long) field.get(entity);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }


        if(id!=null&& !StringUtils.isEmpty(clearRedisCacheKeys())){
            Long finalId = id;
            Arrays.stream(cacheKeys.split(",")).forEach(key->{
                redisTemplate.delete(key.trim()+ finalId);
            });



        }
    }

    @Transactional
    @Override
    public void batchSave(List<E> entitys){
        for(E entity: entitys){
            getEntityDao().insert(entity);
            clearRedisCache(entity);
        }
    }

    @Transactional
    @Override
    public void batchRemove(List<PK> entitys){
        for(PK entity: entitys){
            getEntityDao().deleteById(entity);
            clearRedisCache(entity);
        }
    }


}