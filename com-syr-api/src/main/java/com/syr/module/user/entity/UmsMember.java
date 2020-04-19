package com.syr.module.user.entity;

import com.syr.module.base.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 会员表实体类
 * @author by imall core generator
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsMember implements Serializable {
	public static final String ID = "ID";
	public static final String MEMBER_LEVEL_ID = "MEMBER_LEVEL_ID";
	public static final String USERNAME = "USERNAME";
	public static final String PASSWORD = "PASSWORD";
	public static final String NICKNAME = "NICKNAME";
	public static final String PHONE = "PHONE";
	public static final String STATUS = "STATUS";
	public static final String CREATE_TIME = "CREATE_TIME";
	public static final String ICON = "ICON";
	public static final String GENDER = "GENDER";
	public static final String BIRTHDAY = "BIRTHDAY";
	public static final String CITY = "CITY";
	public static final String JOB = "JOB";
	public static final String PERSONALIZED_SIGNATURE = "PERSONALIZED_SIGNATURE";
	public static final String SOURCE_TYPE = "SOURCE_TYPE";
	public static final String INTEGRATION = "INTEGRATION";
	public static final String GROWTH = "GROWTH";
	public static final String LUCKEY_COUNT = "LUCKEY_COUNT";
	public static final String HISTORY_INTEGRATION = "HISTORY_INTEGRATION";

	/** ID - 会员ID */

	@TableId
	private java.lang.Long id;
	/** MEMBER_LEVEL_ID - member_level_id */

	private java.lang.Long memberLevelId;
	/** USERNAME - 用户名 */

	private java.lang.String username;
	/** PASSWORD - 密码 */

	private java.lang.String password;
	/** NICKNAME - 昵称 */

	private java.lang.String nickname;
	/** PHONE - 手机号码 */

	private java.lang.String phone;
	/** STATUS - 帐号启用状态:0->禁用；1->启用 */

	private java.lang.Integer status;
	/** CREATE_TIME - 注册时间 */

	private java.util.Date createTime;
	/** ICON - 头像 */

	private java.lang.String icon;
	/** GENDER - 性别：0->未知；1->男；2->女 */

	private java.lang.Integer gender;
	/** BIRTHDAY - 生日 */

	private java.util.Date birthday;
	/** CITY - 所做城市 */

	private java.lang.String city;
	/** JOB - 职业 */

	private java.lang.String job;
	/** PERSONALIZED_SIGNATURE - 个性签名 */

	private java.lang.String personalizedSignature;
	/** SOURCE_TYPE - 用户来源 */

	private java.lang.Integer sourceType;
	/** INTEGRATION - 积分 */

	private java.lang.Integer integration;
	/** GROWTH - 成长值 */

	private java.lang.Integer growth;
	/** LUCKEY_COUNT - 剩余抽奖次数 */

	private java.lang.Integer luckeyCount;
	/** HISTORY_INTEGRATION - 历史积分数量 */

	private java.lang.Integer historyIntegration;


}