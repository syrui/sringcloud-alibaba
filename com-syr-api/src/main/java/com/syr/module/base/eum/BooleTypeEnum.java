package com.syr.module.base.eum;

/**
 * @author frt
 * @date 2018/10/20 19:43
 */
public enum  BooleTypeEnum implements IBaseEnum<BooleTypeEnum>{
    /**
     * yes
     */
    Y("Y","是"),
    /**
     * no
     */
    N("N","否");

    private String code;
    private String name;

    BooleTypeEnum(String code, String name) {
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

    public boolean toBoolean(){
        return this.code.equals(BooleTypeEnum.Y.toCode());
    }

    public static String fromBoolean(boolean value){
        return value ? BooleTypeEnum.Y.toCode() : BooleTypeEnum.N.toCode();
    }

    public static BooleTypeEnum fromCode(String code) {
        for (BooleTypeEnum sexTypeEnum : BooleTypeEnum.values()) {
            if (sexTypeEnum.toCode().equals(code)){
                return sexTypeEnum;
            }
        }
        return null;
    }

    public boolean boolValue() {
        return this.ordinal() == 0;
    }
}
