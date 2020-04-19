<#assign className=table.className>
<#assign classNameLower=className?uncap_first>
<#assign classNameFirstLower=className?uncap_first>

package ${basepackage}.${moduleName}.controller;



import com.syr.module.base.result.BaseProvider;
import ${basepackage}.${moduleName}.entity.${className};
import ${basepackage}.${moduleName}.feign.${className}FeignService;
import ${basepackage}.${moduleName}.service.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/${classNameFirstLower}")
public class ${className}Controller extends BaseProvider {
    @Autowired
    ${className}Service ${classNameFirstLower}Service;
    @Resource
    private ${className}FeignService ${classNameFirstLower}FeignService;

    @RequestMapping("index")
    public String index(){
        return "hello user";
        }
}