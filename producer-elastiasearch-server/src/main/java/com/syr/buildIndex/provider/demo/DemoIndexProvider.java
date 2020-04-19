package com.syr.buildIndex.provider.demo;

import com.syr.buildIndex.entity.DemoEntity;
import com.syr.module.base.result.BaseResponse;
import com.syr.module.base.result.BusinessException;
import com.syr.module.base.search.IIndexProvider;
import com.syr.module.demo.entity.Demo;
import com.syr.module.demo.feign.DemoFeignService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author syr
 * @Description
 * @create 2020-03-11 17:26
 **/
@Component
public class DemoIndexProvider implements IIndexProvider<DemoEntity> {

    @Resource
    private DemoFeignService demoFeignService;

    @Override
    public DemoEntity getEntity(Long id) throws BusinessException {
        BaseResponse baseResponse = demoFeignService.domeById(id);
        if(baseResponse.getData()==null&&(Demo) baseResponse.getData()!=null){
            return null;
        }
        Demo demo = (Demo) baseResponse.getData();
        DemoEntity demoEntity = new DemoEntity();
        BeanUtils.copyProperties(demo,demoEntity);
        int[] bounds=new int[]{45,78,62,89,36,78,25,1,35,78};
        demoEntity.setBounds(bounds);
        return demoEntity;
    }
}
