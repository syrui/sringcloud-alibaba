        package com.syr.module.system.entity;

import com.syr.module.base.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * SYS_AUTH【授权】实体类
 * @author by imall core generator
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auth implements Serializable {
	public static final String AUTH_ID = "authId";
	public static final String SYS_USER_ID = "sysUserId";
	public static final String ROLE_ID = "roleId";
	public static final String CREATE_DATE = "createDate";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
	public static final String LAST_MODIFIED_BY = "lastModifiedBy";

	/** AUTH_ID - 授权ID */
	@TableId
	private java.lang.Long authId;
	/** SYS_USER_ID - 用户ID */

	private java.lang.Long sysUserId;
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