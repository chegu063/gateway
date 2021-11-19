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
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author chegu
 * @date 2021/4/13  16:28
 */
public class CodeGenerator {

    private final GenerateProperties properties;

    public CodeGenerator(GenerateProperties properties) {
        this.properties = properties;
    }

    public void generate() {
        AutoGenerator generator = new AutoGenerator();
        //配置数据库连接参数
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://" + properties.getMysqlConfig().getDatabase() + "?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&allowMultiQueries=true")
                .setUsername(properties.getMysqlConfig().getUser())
                .setPassword(properties.getMysqlConfig().getPassword());
        generator.setDataSource(dataSourceConfig);

        String moduleUrl = Optional.ofNullable(properties.getModuleUrl()).orElse(System.getProperty("user.dir").replace("\\","/"));

        //配置文件生成路径参数
        String javaPath = moduleUrl + "/src/main/java/" + properties.getOutputDir()  + "/";
        String resourcesPath = moduleUrl + "/src/main/resources/";
        HashMap<String, String> pathInfo = new HashMap<>(6);
        pathInfo.put(ConstVal.ENTITY_PATH, javaPath + properties.getEntityDir());
        pathInfo.put(ConstVal.CONTROLLER_PATH, javaPath + properties.getControllerDir());
        pathInfo.put(ConstVal.SERVICE_PATH, javaPath + properties.getServiceDir());
        pathInfo.put(ConstVal.SERVICE_IMPL_PATH, javaPath + properties.getServiceImplDir());
        pathInfo.put(ConstVal.MAPPER_PATH, javaPath + properties.getMapperDir());
        pathInfo.put(ConstVal.XML_PATH, resourcesPath + properties.getResourceXmlDir());
        //配置包名
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(properties.getOutputDir().replace("/", "."))
                .setEntity(properties.getEntityDir().replace("/", "."))
                .setController(properties.getControllerDir().replace("/", "."))
                .setService(properties.getServiceDir().replace("/", "."))
                .setServiceImpl(properties.getServiceImplDir().replace("/", "."))
                .setMapper(properties.getMapperDir().replace("/", "."))
                .setPathInfo(pathInfo);
        generator.setPackageInfo(packageConfig);

        //引擎设置
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.setCfg(new InjectionConfig() {
            @Override
            public void initMap() {
            }
        });

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel)
                .setEntityBuilderModel(true)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityTableFieldAnnotationEnable(true)
                .setTablePrefix(properties.getMysqlConfig().getTablePrefix())
                .setInclude(properties.getMysqlConfig().getTables()
                )
        ;
        generator.setStrategy(strategyConfig);

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //输出目录
        globalConfig.setFileOverride(true)
                .setSwagger2(true)
                .setAuthor("chegu")
                .setOutputDir(moduleUrl + "/src/main")
                .setOpen(true)
                .setIdType(IdType.AUTO)
                .setBaseColumnList(true)
                .setBaseResultMap(true);
        generator.setGlobalConfig(globalConfig);
        generator.execute();
    }

}