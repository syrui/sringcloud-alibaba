package com.syr.module.base.eum;

/**
 * @author liezihao
 * @description： 角色类型
 **/
public enum RoleTypeEnum implements IBaseEnum<RoleTypeEnum> {
    /**
     * 管理员
     */
    ADMIN("ADMIN", "管理员"),

    /**
     * 连锁营业员
     */
    CHAIN("CHAIN", "连锁营业员"),

    /**
     * 门店营业员
     */
    SHOP("SHOP", "门店营业员"),
    ;

    private String code;
    private String name;

    RoleTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toName() {
        return name;
    }

    @Override
    public String toCode() {
        return code;
    }

    public static RoleTypeEnum fromCode(String code) {
        for (RoleTypeEnum typeEnum : RoleTypeEnum.values()) {
            if (typeEnum.toCode().equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }
}
