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


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author chegu
 * @date 2021/4/15  11:07
 */
@ConfigurationProperties(prefix = "code.generate")
public class GenerateProperties {

    @NestedConfigurationProperty
    private MysqlConfig mysqlConfig = new MysqlConfig();
    /**
     * 模块名
     */
    private String moduleUrl;
    /**
     * java文件夹下的文件路径
     */
    private String outputDir = "top/chegu/admin";
    private String entityDir = "bean";
    private String controllerDir = "controller";
    private String serviceDir = "service";
    private String serviceImplDir = "service/impl";
    private String mapperDir = "mapper";
    /**
     * resources文件夹下的xml文件路径
     */
    private String resourceXmlDir = "mapper";


    public MysqlConfig getMysqlConfig() {
        return mysqlConfig;
    }

    public void setMysqlConfig(MysqlConfig mysqlConfig) {
        this.mysqlConfig = mysqlConfig;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public String getEntityDir() {
        return entityDir;
    }

    public String getControllerDir() {
        return controllerDir;
    }

    public String getServiceDir() {
        return serviceDir;
    }

    public String getServiceImplDir() {
        return serviceImplDir;
    }

    public String getMapperDir() {
        return mapperDir;
    }

    public String getResourceXmlDir() {
        return resourceXmlDir;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public void setEntityDir(String entityDir) {
        this.entityDir = entityDir;
    }

    public void setControllerDir(String controllerDir) {
        this.controllerDir = controllerDir;
    }

    public void setServiceDir(String serviceDir) {
        this.serviceDir = serviceDir;
    }

    public void setServiceImplDir(String serviceImplDir) {
        this.serviceImplDir = serviceImplDir;
    }

    public void setMapperDir(String mapperDir) {
        this.mapperDir = mapperDir;
    }

    public void setResourceXmlDir(String resourceXmlDir) {
        this.resourceXmlDir = resourceXmlDir;
    }


}
