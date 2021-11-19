package top.chegu.common.entity.dto;

/**
 * @author chegu
 * @date 2021/4/13  10:41
 */
public class UnRegisterAppDTO {

    private String ip;

    private Integer port;

    private String appName;

    private String version;

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

    @Override
    public String toString() {
        return "UnRegisterAppDTO{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", appName='" + appName + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
