package com.syr.module.base.eum;


public enum AccountTypeEnum implements IBaseEnum<AccountTypeEnum> {
    /**
     * 积分
     */
    INTEGRAL("INTEGRAL", "积分"),


    ;

    private String code;
    private String name;

    AccountTypeEnum(String code, String name) {
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

    public static AccountTypeEnum fromCode(String code) {
        for (AccountTypeEnum typeEnum : AccountTypeEnum.values()) {
            if (typeEnum.toCode().equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }
}
