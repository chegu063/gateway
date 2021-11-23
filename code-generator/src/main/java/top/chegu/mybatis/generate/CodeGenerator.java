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

import java.util.EnumMap;
import java.util.Map;
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
        //配置数据库连接参数
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder("jdbc:mysql://" + properties.getMysqlConfig().getDatabase() +
                "?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&allowMultiQueries=true",
                properties.getMysqlConfig().getUser(),properties.getMysqlConfig().getPassword()).build();

        String moduleUrl = Optional.ofNullable(properties.getModuleUrl()).orElse(System.getProperty("user.dir").replace("\\","/"));

        //配置文件生成路径参数
        String javaPath = moduleUrl + "/src/main/java/" + properties.getOutputDir()  + "/";
        String resourcesPath = moduleUrl + "/src/main/resources/";
        Map<OutputFile, String> pathInfo = new EnumMap<>(OutputFile.class);
        pathInfo.put(OutputFile.entity, javaPath + properties.getEntityDir());
        pathInfo.put(OutputFile.controller, javaPath + properties.getControllerDir());
        pathInfo.put(OutputFile.service, javaPath + properties.getServiceDir());
        pathInfo.put(OutputFile.serviceImpl, javaPath + properties.getServiceImplDir());
        pathInfo.put(OutputFile.mapper, javaPath + properties.getMapperDir());
        pathInfo.put(OutputFile.mapperXml, resourcesPath + properties.getResourceXmlDir());
        //配置包名
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent(properties.getOutputDir().replace("/", "."))
                .entity(properties.getEntityDir().replace("/", "."))
                .controller(properties.getControllerDir().replace("/", "."))
                .service(properties.getServiceDir().replace("/", "."))
                .serviceImpl(properties.getServiceImplDir().replace("/", "."))
                .mapper(properties.getMapperDir().replace("/", "."))
                .pathInfo(pathInfo)
                .build();
        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                .addTablePrefix(properties.getMysqlConfig().getTablePrefix())
                .addInclude(properties.getMysqlConfig().getTables())
                .entityBuilder().enableTableFieldAnnotation().enableLombok()
                .controllerBuilder().enableRestStyle()
                .mapperBuilder().enableBaseColumnList().enableBaseResultMap()
                .build();


        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .fileOverride()
                .enableSwagger()
                .author("chegu")
                .outputDir(moduleUrl + "/src/main")
                .build();

        AutoGenerator generator = new AutoGenerator(dataSourceConfig)
                .packageInfo(packageConfig)
                .strategy(strategyConfig)
                .global(globalConfig);
        generator.execute();
    }

}