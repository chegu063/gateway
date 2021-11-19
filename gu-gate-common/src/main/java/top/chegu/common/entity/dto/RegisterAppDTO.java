package top.chegu.common.entity.dto;

/**
 * @author chegu
 * @date 2021/4/12  14:41
 */
public class RegisterAppDTO {
    private String ip;

    private Integer port;

    private String appName;

    private String version;

    private String contextPath;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

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

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
    @Override
    public String toString() {
        return "RegisterAppDTO{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", appName='" + appName + '\'' +
                ", version='" + version + '\'' +
                ", contextPath='" + contextPath + '\'' +
                '}';
    }
}
