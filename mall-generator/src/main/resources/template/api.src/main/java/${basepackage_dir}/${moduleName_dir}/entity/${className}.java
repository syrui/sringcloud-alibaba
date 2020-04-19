<#assign className=table.className>
<#assign classNameLower=className?uncap_first>
package ${basepackage}.${moduleName}.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ${table.remarks}实体类
 * @author by imall core generator
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("${table.sqlName}" )
public class ${className} implements Serializable {
	<#list table.columns as column>
	public static final String ${column.constantName} = "${column.constantName}";
	</#list>

	<#list table.columns as column>
	/** ${column.sqlName?upper_case} - ${column.columnAlias} */

	<#if column.pk>
	@TableId
   </#if>
	private ${column.javaType} ${column.columnNameLower};
	</#list>


}