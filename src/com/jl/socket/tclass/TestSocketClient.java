package com.jl.socket.tclass;

import java.io.IOException;
import java.net.Socket;

/**
 * @ClassName TestSocketClient
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/3/13 21:20
 * @Version 1.0
 */
public class TestSocketClient {
    public static void main(String[] args){
        //java.net.Socket类代表客户端和服务器都用来相互沟通的套接字。
        //客户端要获取一个Socket对象通过实例化，而服务器获得一个Socket对象则通过accept()方法的返回值
        try {
            Socket socket = new Socket();
            Socket ipport = new Socket("127.0.0.1",54321);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
