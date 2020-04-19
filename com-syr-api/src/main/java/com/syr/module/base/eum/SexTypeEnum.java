package com.syr.module.base.eum;

/**
 * @author chencheng
 * @date 2017/11/22
 * 性别类型
 */
public enum SexTypeEnum implements IBaseEnum<SexTypeEnum>{

    /**
     * 男
     */
    MALE("MALE","男"),
    /**
     * 女
     */
    FEMALE("FEMALE","女"),
    /**
     * 保密
     */
    SECRET("SECRET","保密"),
    /**
     * 全部
     */
    ALL("ALL","全部");

    private String code;
    private String name;

    SexTypeEnum(String code, String name) {
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


    public static SexTypeEnum fromCode(String code) {
        for (SexTypeEnum sexTypeEnum : SexTypeEnum.values()) {
            if (sexTypeEnum.toCode().equals(code)){
                return sexTypeEnum;
            }
        }
        return null;
    }
}
