/*
 * Copyright (c) 2021 chegu <1107313063@qq.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.chegu.mybatis.generate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;

/**
 * @author chegu
 * @date 2021/4/13  16:28
 */
public class AdminGenerator {

    private static String[] databasesName = {
            "t_plugin"
    };

    /**
     * mysql配置
     */
    public static final String MYSQL_URL = "192.168.145.144:3306/gu_gate";
    public static final String MYSQL_USER = "root";
    public static final String MYSQL_PASSWORD = "root123";
    /**
     * 表前缀
     */
    public static final String TABLE_PREFIX = "t_";
    /**
     * 模块名
     */
    public static final String MODULE_URL = "E:/project/gu-gate/gu-admin";
    /**
     * java文件夹下的文件路径
     */
    public static final String OUTPUT_PATH = "top/chegu/admin";
    public static final String ENTITY_DIR = "bean";
    public static final String CONTROLLER_DIR = "controller";
    public static final String SERVICE_DIR = "service";
    public static final String SERVICE_IMPL_DIR = "service/impl";
    public static final String MAPPER_DIR = "mapper";
    /**
     * resources文件夹下的文件路径
     */
    public static final String RESOURCE_XML_DIR = "mapper";



    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();
        //配置数据库连接参数
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://" + MYSQL_URL + "?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&allowMultiQueries=true")
                .setUsername(MYSQL_USER)
                .setPassword(MYSQL_PASSWORD);
        generator.setDataSource(dataSourceConfig);


        //配置文件生成路径参数
        String javaPath = MODULE_URL + "/src/main/java/" + OUTPUT_PATH  + "/";
        String resourcesPath = MODULE_URL + "/src/main/resources/";
        HashMap<String, String> pathInfo = new HashMap<>(6);
        pathInfo.put(ConstVal.ENTITY_PATH, javaPath + ENTITY_DIR);
        pathInfo.put(ConstVal.CONTROLLER_PATH, javaPath + CONTROLLER_DIR);
        pathInfo.put(ConstVal.SERVICE_PATH, javaPath + SERVICE_DIR);
        pathInfo.put(ConstVal.SERVICE_IMPL_PATH, javaPath + SERVICE_IMPL_DIR);
        pathInfo.put(ConstVal.MAPPER_PATH, javaPath + MAPPER_DIR);
        pathInfo.put(ConstVal.XML_PATH, resourcesPath + RESOURCE_XML_DIR);
        //配置包名
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(OUTPUT_PATH.replace("/", "."))
                .setEntity(ENTITY_DIR.replace("/", "."))
                .setController(CONTROLLER_DIR.replace("/", "."))
                .setService(SERVICE_DIR.replace("/", "."))
                .setServiceImpl(SERVICE_IMPL_DIR.replace("/", "."))
                .setMapper(MAPPER_DIR.replace("/", "."))
                .setPathInfo(pathInfo);
        generator.setPackageInfo(packageConfig);

        //引擎设置
        generator.setTemplateEngine(new FreemarkerTemplateEngine());

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel)
                .setEntityBuilderModel(true)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityTableFieldAnnotationEnable(true)
                .setTablePrefix(TABLE_PREFIX)
                .setInclude(databasesName)
        ;
        generator.setStrategy(strategyConfig);

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //输出目录
        globalConfig.setFileOverride(true)
                .setSwagger2(true)
                .setAuthor("chegu")
                .setOutputDir(MODULE_URL + "/src/main")
                .setOpen(true)
                .setIdType(IdType.AUTO)
                .setBaseColumnList(true)
                .setBaseResultMap(true);
        generator.setGlobalConfig(globalConfig);
        generator.execute();
    }

}