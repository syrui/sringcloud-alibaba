package com.imall.generator;

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;

public class GeneratorMain {
    public static void main(String[] args) throws Exception {
        GeneratorFacade generatorFacade = new GeneratorFacade();
        //删除生成器的输出目录 position

        generatorFacade.deleteOutRootDir();
        //设置模板
        generatorFacade.getGenerator().addTemplateRootDir("classpath:template");

        //TODO:步骤一：改模块名称，最终生成的包结构以generator.xml的参数 basepackage + moduleName 为结果，例如 com.imall.yx.module.rbac
        GeneratorProperties.setProperty("moduleName","user");
        //TODO:步骤二：填入要生成代码的表名称，可以多个表但须以 ',' 分开
        String tables = "ums_member";
        for(String table : tables.split(",")){
            generatorFacade.generateByTable(table);
        }

        //打开生成器的输出目录
        Runtime.getRuntime().exec("cmd.exe /c start "+GeneratorProperties.getRequiredProperty("outRoot"));
    }
}
