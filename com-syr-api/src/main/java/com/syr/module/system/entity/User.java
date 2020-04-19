        package com.syr.module.system.entity;

import com.syr.module.base.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * SYS_USER【用户】实体类
 * @author by imall core generator
 * @version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	public static final String SYS_USER_ID = "sysUserId";
	public static final String EMPLOYEE_CODE = "employeeCode";
	public static final String LOGIN_ID = "loginId";
	public static final String REAL_NAME = "realName";
	public static final String EMAIL = "email";
	public static final String MOBILE = "mobile";
	public static final String PASSWORD = "password";
	public static final String SEX = "sex";
	public static final String SALT = "salt";
	public static final String IF_ALLOW_LOGIN = "ifAllowLogin";
	public static final String IS_DELETED = "isDeleted";
	public static final String MARK = "mark";
	public static final String CREATE_DATE = "createDate";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
	public static final String LAST_MODIFIED_BY = "lastModifiedBy";
	public static final String CHAIN_ID = "chainId";
	public static final String IS_DEFAULT_USER = "isDefaultUser";
	public static final String SHOP_ID = "shopId";
	public static final String ICON_FILE_ID = "iconFileId";
	public static final String PLATFORM_TYPE = "platformType";
	public static final String OPEN_ID = "openId";

	/** SYS_USER_ID - 用户ID */

	@TableId
	private java.lang.Long sysUserId;
	/** EMPLOYEE_CODE - 员工编号 */


	private java.lang.String employeeCode;
	/** LOGIN_ID - 登录 ID */


	private java.lang.String loginId;
	/** REAL_NAME - 真实姓名 */


	private java.lang.String realName;
	/** EMAIL - 邮箱 */


	private java.lang.String email;
	/** MOBILE - 手机号 */


	private java.lang.String mobile;
	/** PASSWORD - 密码 */


	private java.lang.String password;
	/** SEX - 性别 */


	private java.lang.String sex;
	/** SALT - 加密密码时使用的种子 */


	private java.lang.String salt;
	/** IF_ALLOW_LOGIN - 是否允许登陆 */


	private java.lang.String ifAllowLogin;
	/** IS_DELETED - 是否删除 */


	private java.lang.String isDeleted;
	/** MARK - 备注 */


	private java.lang.String mark;
	/** CREATE_DATE - 创建日期 */


	private java.util.Date createDate;
	/** CREATE_BY - 创建人 */


	private java.lang.Long createBy;
	/** LAST_MODIFIED_DATE - 更新时间 */


	private java.util.Date lastModifiedDate;
	/** LAST_MODIFIED_BY - 更新用户 */


	private java.lang.Long lastModifiedBy;
	/** CHAIN_ID - 连锁ID */


	private java.lang.Long chainId;
	/** IS_DEFAULT_USER - 是否默认账号 */


	private java.lang.String isDefaultUser;
	/** SHOP_ID - 店铺ID */


	private java.lang.Long shopId;
	/** ICON_FILE_ID - 头像 文件 ID */


	private java.lang.String iconFileId;
	/** PLATFORM_TYPE - 平台类型 */


	private java.lang.String platformType;
	/** OPEN_ID - 微信OPEN_ID */


	private java.lang.String openId;


}