<#assign className=table.className>
package ${basepackage}.${moduleName}.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${basepackage}.${moduleName}.entity.${className};
import org.apache.ibatis.annotations.Mapper;

/**
 * 库存单元表 JPA 持久化层
         * @author by imall core generator
        * @version 1.0.0
        */
@Mapper
public interface ${className}Mapper extends BaseMapper<${className}> {


}