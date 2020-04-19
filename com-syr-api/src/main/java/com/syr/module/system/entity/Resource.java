package com.syr.module.system.entity;

import com.syr.module.base.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * SYS_RESOURCE【资源】实体类
 * @author by imall core generator
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource implements Serializable {
	public static final String RES_ID = "resId";
	public static final String RES_NAME = "resName";
	public static final String PERMISSION_RES_CODE = "permissionResCode";
	public static final String RES_CODE = "resCode";
	public static final String MENU_URL = "menuUrl";
	public static final String MENU_ICON = "menuIcon";
	public static final String PARENT_RES_CODE = "parentResCode";
	public static final String SORT = "sort";
	public static final String RES_TYPE = "resType";
	public static final String USAGE_RANGE = "usageRange";

	/** RES_ID - 主键 */

	@TableId
	private java.lang.Long resId;
	/** RES_NAME - 资源名称 */


	private java.lang.String resName;
	/** PERMISSION_RES_CODE - 权限 编码 */

	private java.lang.String permissionResCode;
	/** RES_CODE - 资源编码 */


	private java.lang.String resCode;
	/** MENU_URL - 菜单 URL */


	private java.lang.String menuUrl;
	/** MENU_ICON - 菜单 图标 */

	private java.lang.String menuIcon;
	/** PARENT_RES_CODE - 父级 编码 */


	private java.lang.String parentResCode;
	/** SORT - 顺序 */


	private java.lang.Long sort;
	/** RES_TYPE - 资源类型 */


	private java.lang.String resType;
	/** USAGE_RANGE - 使用范围 */


	private java.lang.String usageRange;



}