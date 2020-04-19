<#assign className=table.className>
package ${basepackage}.${moduleName}.feign;

import com.syr.module.base.eum.ErrorCode;
import com.syr.module.base.result.BaseProvider;
import com.syr.module.base.result.BaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ${className}FallbackService extends BaseProvider implements ${className}FeignService {

}