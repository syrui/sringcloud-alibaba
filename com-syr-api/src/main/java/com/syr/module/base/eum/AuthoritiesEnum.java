package com.syr.module.base.eum;

/**
 * @author frt
 * @date 2018/11/16 11:35
 */
public enum AuthoritiesEnum implements IBaseEnum<AuthoritiesEnum> {
    /**
     * 启用
     */
    ENABLE("ENABLE", "启用"),

    /**
     * 禁用
     */
    DISABLE("DISABLE", "禁用")

    ;

    AuthoritiesEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private String code;
    private String name;

    @Override
    public String toCode() {
        return this.code;
    }

    @Override
    public String toName() {
        return this.name;
    }

    public static AuthoritiesEnum fromCode(String code){
        for(AuthoritiesEnum authoritiesEnum : AuthoritiesEnum.values()){
            if(authoritiesEnum.toCode().equals(code)){
                return authoritiesEnum;
            }
        }

        return null;
    }
}
