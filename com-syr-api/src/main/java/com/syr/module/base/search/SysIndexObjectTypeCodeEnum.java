package com.syr.module.base.search;


/**
 * @author syr
 * @Description
 * @create 2020-03-11 17:15
 **/
public enum SysIndexObjectTypeCodeEnum {
    DEMO("demo_entity","demo")
    ;
    private String index;
    private String type;

    SysIndexObjectTypeCodeEnum(String index, String type) {
        this.index = index;
        this.type = type;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}