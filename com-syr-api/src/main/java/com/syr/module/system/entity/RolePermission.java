        package com.syr.module.system.entity;

import com.syr.module.base.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * SYS_ROLE_PERMISSION【角色资源权限】实体类
 * @author by imall core generator
 * @version 1.0.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePermission implements Serializable {
	public static final String PERMISSION_ID = "permissionId";
	public static final String RES_ID = "RES_ID";
	public static final String ROLE_ID = "ROLE_ID";
	public static final String CREATE_DATE = "createDate";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
	public static final String LAST_MODIFIED_BY = "lastModifiedBy";

	/** PERMISSION_ID - 主键 */

	@TableId
	private java.lang.Long permissionId;
	/** RES_ID - 资源ID */


	private java.lang.Long resId;
	/** ROLE_ID - 角色ID */


	private java.lang.Long roleId;
	/** CREATE_DATE - 创建日期 */


	private java.util.Date createDate;
	/** CREATE_BY - 创建人 */


	private java.lang.Long createBy;
	/** LAST_MODIFIED_DATE - 更新时间 */


	private java.util.Date lastModifiedDate;
	/** LAST_MODIFIED_BY - 更新用户 */


	private java.lang.Long lastModifiedBy;


}