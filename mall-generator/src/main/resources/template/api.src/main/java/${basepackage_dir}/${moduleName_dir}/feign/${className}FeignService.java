<#assign className=table.className>
package ${basepackage}.${moduleName}.feign;
import com.syr.module.base.result.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这是一个声明式的远程调用
 */

@Component
@FeignClient(value = "XXXX",fallback = ${className}FallbackService.class)
public interface ${className}FeignService {

}