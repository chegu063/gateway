package top.chegu.gate;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author chegu
 * @date 2021/4/9  14:54
 */
@ConfigurationProperties(prefix = "gu.http")
public class GuClientProperties {

    /**
     * 端口
     */
    private Integer port;

    /**
     * appName
     */
    private String appName;

    /**
     * 版本号
     */
    private String version;

    /**
     * 管理地址
     */
    private String adminUrl;

    /**
     * 请求根路径
     */
    private String contextPath;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAdminUrl() {
        return adminUrl;
    }

    public void setAdminUrl(String adminUrl) {
        this.adminUrl = adminUrl;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
}
