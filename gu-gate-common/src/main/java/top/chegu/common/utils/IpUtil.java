package top.chegu.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author chegu
 * @date 2021/4/12  14:00
 */
public class IpUtil {

    public static String getIp(){
        InetAddress localHost = null;
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return localHost != null ? localHost.getHostAddress() : null;
    }
}
