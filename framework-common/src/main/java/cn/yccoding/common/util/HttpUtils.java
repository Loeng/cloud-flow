//package cn.yccoding.common.util;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import javax.servlet.http.HttpServletRequest;
//
///**
// * http工具类
// * @author YC
// * @since 2020/6/3 18:20
// */
//public class HttpUtils {
//    public static String getIpAddr(HttpServletRequest request) {
//        String ipAddress = null;
//        try {
//            ipAddress = request.getHeader("x-forwarded-for");
//            String unknownIp = "unknown";
//            if (ipAddress == null || ipAddress.length() == 0 || unknownIp.equalsIgnoreCase(ipAddress)) {
//                ipAddress = request.getHeader("Proxy-Client-IP");
//            }
//            if (ipAddress == null || ipAddress.length() == 0 || unknownIp.equalsIgnoreCase(ipAddress)) {
//                ipAddress = request.getHeader("WL-Proxy-Client-IP");
//            }
//            if (ipAddress == null || ipAddress.length() == 0 || unknownIp.equalsIgnoreCase(ipAddress)) {
//                ipAddress = request.getRemoteAddr();
//                String localIp = "127.0.0.1";
//                if (localIp.equals(ipAddress)) {
//                    // 根据网卡取本机配置的IP
//                    InetAddress inet = null;
//                    try {
//                        inet = InetAddress.getLocalHost();
//                    } catch (UnknownHostException e) {
//                        e.printStackTrace();
//                    }
//                    ipAddress = inet.getHostAddress();
//                }
//            }
//            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
//            // "***.***.***.***".length()
//            int maxIpSize = 15;
//            if (ipAddress != null && ipAddress.length() > maxIpSize) {
//                String comma = ",";
//                if (ipAddress.indexOf(comma) > 0) {
//                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(comma));
//                }
//            }
//        } catch (Exception e) {
//            ipAddress="";
//        }
//        return ipAddress;
//    }
//
//    public static String getRequestUrl(HttpServletRequest request) {
//        String url = request.getQueryString() == null ? request.getRequestURL().toString()
//                : request.getRequestURL() + "?" + request.getQueryString();
//        return url;
//    }
//
//}
