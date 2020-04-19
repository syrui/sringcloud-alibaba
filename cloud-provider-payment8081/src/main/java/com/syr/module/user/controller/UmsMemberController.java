
package com.syr.module.user.controller;



import com.syr.module.base.result.BaseProvider;
import com.syr.module.user.entity.UmsMember;
import com.syr.module.user.feign.UmsMemberFeignService;
import com.syr.module.user.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController()
@RequestMapping("/umsMember")
public class UmsMemberController extends BaseProvider {
    @Autowired
    UmsMemberService umsMemberService;
    @Resource
    private UmsMemberFeignService umsMemberFeignService;

    @RequestMapping("index")
    public String index(){
        return "hello user";
    }

    @RequestMapping("all")
    public Object getAll(){

        List<UmsMember> list = umsMemberService.getAll();
        return handleSuccess(list);
    }
}