package com.jl.socket.tclass;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName TestInetAddress
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/3/14 9:16
 * @Version 1.0
 */
public class TestInetAddress {
    public static void main(String[] args){
        //java.net.InetAddress表示互联网（IP）协议。
        try {
            byte[] ip2 = new byte[]{(byte)127,0,0,1};
            //在给定原始IP的情况下，返回InetAddress对象
            InetAddress ia = InetAddress.getByAddress(ip2);
            //根据主机名和IP地址来创建InetAddress对象
            InetAddress hostIp = InetAddress.getByAddress(InetAddress.getLocalHost().getHostName(),ip2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
