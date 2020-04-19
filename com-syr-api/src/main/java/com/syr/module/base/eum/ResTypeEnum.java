package com.syr.module.base.eum;

/**
 * Created by frt on 2017/11/21.
 * 资源类型
 */
public enum ResTypeEnum implements IBaseEnum<ResTypeEnum> {
    /**
     * 菜单
     */
    MENU("MENU", "菜单"),

    /**
     * 按钮
     */
    BUTTON("BUTTON", "按钮");

    private String code;
    private String name;

    ResTypeEnum(String code, String name) {
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

    public static ResTypeEnum fromCode(String code) {
        for (ResTypeEnum resTypeEnum : ResTypeEnum.values()) {
            if (resTypeEnum.toCode().equals(code)) {
                return resTypeEnum;
            }
        }

        return null;
    }
}
