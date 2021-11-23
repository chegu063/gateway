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

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author chegu
 * @date 2021/4/13  16:28
 */
public class AdminGenerator {

    private static String[] databasesName = {
            "t_name"
    };

    /**
     * mysql配置
     */
    public static final String MYSQL_URL = "192.168.145.130:3366/gu_gate";
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
        //配置数据库连接参数
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder("jdbc:mysql://" + MYSQL_URL +
                "?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&allowMultiQueries=true",MYSQL_USER,MYSQL_PASSWORD).build();

        //配置文件生成路径参数
        String javaPath = MODULE_URL + "/src/main/java/" + OUTPUT_PATH  + "/";
        String resourcesPath = MODULE_URL + "/src/main/resources/";
        Map<OutputFile, String> pathInfo = new EnumMap<>(OutputFile.class);
        pathInfo.put(OutputFile.entity, javaPath + ENTITY_DIR);
        pathInfo.put(OutputFile.controller, javaPath + CONTROLLER_DIR);
        pathInfo.put(OutputFile.service, javaPath + SERVICE_DIR);
        pathInfo.put(OutputFile.serviceImpl, javaPath + SERVICE_IMPL_DIR);
        pathInfo.put(OutputFile.mapper, javaPath + MAPPER_DIR);
        pathInfo.put(OutputFile.mapperXml, resourcesPath + RESOURCE_XML_DIR);
        //配置包名
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent(OUTPUT_PATH.replace("/", "."))
                .controller(CONTROLLER_DIR.replace("/", "."))
                .entity(ENTITY_DIR.replace("/", "."))
                .service(SERVICE_DIR.replace("/", "."))
                .serviceImpl(SERVICE_IMPL_DIR.replace("/", "."))
                .mapper(MAPPER_DIR.replace("/", "."))
                .pathInfo(pathInfo)
                .build();

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .addTablePrefix(TABLE_PREFIX)
                .addInclude(databasesName)
                .entityBuilder().enableTableFieldAnnotation().enableLombok()
                .controllerBuilder().enableRestStyle()
                .mapperBuilder().enableBaseColumnList().enableBaseResultMap()
                .build();

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .fileOverride()
                .enableSwagger()
                .author("chegu")
                .outputDir(MODULE_URL + "/src/main")
                .build();

        AutoGenerator generator = new AutoGenerator(dataSourceConfig)
                .packageInfo(packageConfig)
                .strategy(strategyConfig)
                .global(globalConfig);

        generator.execute(new FreemarkerTemplateEngine());
    }

}