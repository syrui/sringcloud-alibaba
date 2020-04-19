package com.syr.module.base.eum;

/**
 * Created by olx on 2018-10-20 19:18:55
 * 平台类型
 */
public enum PlatformTypeEnum implements IBaseEnum<PlatformTypeEnum> {

    /**
     * 所有
     */
    ALL("ALL", "所有"),
    /**
     * 连锁
     */
    CHAIN("CHAIN", "连锁"),
    /**
     * 店铺
     */
    SHOP("SHOP", "店铺"),

    ;

    private String code;
    private String name;

    PlatformTypeEnum(String code, String name) {
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

    public static PlatformTypeEnum fromCode(String code) {
        for (PlatformTypeEnum typeEnum : PlatformTypeEnum.values()) {
            if (typeEnum.toCode().equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }

}
