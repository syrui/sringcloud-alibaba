package com.syr.module.base.eum;

/**
 * Created by lxd on 2017/11/25.
 * 错误代码
 */
public enum ErrorCode {
    /* 以下定义权限系统的错误代码 */
    SYS_UNKNOWN_ERROR("SYS_UNKNOWN_ERROR", "未知错误"),
    SYS_NOT_FOUND("SYS_NOT_FOUND", "未找到对象"),
    SYS_VALIDATION_ERROR("SYS_VALIDATION_ERROR", "系统校验异常"),
    SYS_USER_LOGIN_ID_REPEAT("SYS_USER_LOGIN_ID_REPEAT", "用户登陆ID=%s已被占用"),
    SYS_USER_NOT_FOUND("SYS_USER_NOT_FOUND", "找不到该用户!用户ID=%s"),
    MAIN_USER_CAN_NOT_DELETE("MAIN_USER_CAN_NOT_DELETE", "主用户不允许删除"),
    SYS_ROLE_REPEAT("SYS_ROLE_REPEAT","系统角色%s已存在"),
    SYS_USER_NOT_LOGIN("SYS_USER_NOT_LOGIN","您未登录"),
    ACCOUNT_OLD_PASSWORD_INCORRECTNESS("ACCOUNT_OLD_PASSWORD_INCORRECTNESS","原密码错误"),
    SYS_OBJ_NOT_FOUND("SYS_OBJ_NOT_FOUND", "%s"),
    OBJ_ATTR_NOT_NULL("OBJ_ATTR_NOT_NULL", "%s"), //对象属性不能为空
    NO_DELETE_PERMISSION("NO_DELETE_PERMISSION", "无删除权限"),
    NO_OPERATION_PERMISSION("NO_OPERATION_PERMISSION", "无操作权限"),
    SYS_OBJECT_IS_NOT_NULL("SYS_OBJECT_IS_NOT_NULL", "%s不能为空"),
    SYS_OBJECT_IS_EXIST("SYS_OBJECT_IS_EXIST", "%s已经存在"),
    ENUM_FROM_CODE_BLANK("ENUM_FROM_CODE_BLANK", "code为空字符串"),
    ENUM_FROM_CODE_ERROR("ENUM_FROM_CODE_ERROR", "未匹配对应枚举项"),

    SMS_OBJ_NOT_FOUND("SMS_OBJ_NOT_FOUND", "短信账号未开通"),
    SMS_ADDRESS_NOT_FOUND("SMS_ADDRESS_NOT_FOUND", "短信接口未设置"),
    SMS_ACCOUNT_NOT_SIGN("SMS_ACCOUNT_NOT_SIGN", "未设置短信签名"),

    // 支付
    SYS_PAY_PASSWORD_WITHOUT_SETTING("SYS_PAY_PASSWORD_WITHOUT_SETTING", "未设置商城支付密码"),
    SYS_PAY_PASSWORD_IS_ERROR("SYS_PAY_PASSWORD_IS_ERROR", "支付密码错误")
    ;

    private String code;
    private String errorMSg;
    ErrorCode(String code, String errorMSg) {
        this.code = code;
        this.errorMSg = errorMSg;
    }

    public String getCode() {
        return code;
    }

    public String getErrorMSg() {
        return errorMSg;
    }
}
