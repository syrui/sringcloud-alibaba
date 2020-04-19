        package com.syr.module.system.entity;

import com.syr.module.base.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * SYS_ROLE【角色】实体类
 * @author by imall core generator
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
	public static final String ROLE_ID = "roleId";
	public static final String ROLE_NAME = "roleName";
	public static final String DESCRIPTION = "description";
	public static final String CREATE_DATE = "createDate";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
	public static final String LAST_MODIFIED_BY = "lastModifiedBy";
	public static final String CHAIN_ID = "chainId";
	public static final String PLATFORM_TYPE = "platformType";
	public static final String SHOP_ID = "shopId";
	public static final String IS_DEFAULT_ROLE = "isDefaultRole";
	public static final String ROLE_TYPE = "roleType";

	/** ROLE_ID - 主键 */

	@TableId
	private java.lang.Long roleId;
	/** ROLE_NAME - 角色名称 */

  /*  @Column(name = "ROLE_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 100)*/

	private java.lang.String roleName;
	/** DESCRIPTION - 描述 */


	private java.lang.String description;
	/** CREATE_DATE - 创建日期 */

	private java.util.Date createDate;
	/** CREATE_BY - 创建人 */


	private java.lang.Long createBy;
	/** LAST_MODIFIED_DATE - 更新时间 */


	private java.util.Date lastModifiedDate;
	/** LAST_MODIFIED_BY - 更新用户 */


	private java.lang.Long lastModifiedBy;
	/** CHAIN_ID - 所属连锁公司 */


	private java.lang.Long chainId;
	/** PLATFORM_TYPE - 平台类型 */


	private java.lang.String platformType;
	/** SHOP_ID - 店铺 ID */


	private java.lang.Long shopId;
	/** IS_DEFAULT_ROLE - 是否默认角色 */


	private java.lang.String isDefaultRole;
	/** ROLE_TYPE - 角色类型 */


	private java.lang.String roleType;


}