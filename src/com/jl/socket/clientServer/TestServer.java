package com.jl.socket.clientServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TestServer
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/3/22 9:39
 * @Version 1.0
 */
public class TestServer {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            byte[] buf = new byte[1024];
            int len = is.read(buf);
            System.out.println(new String(buf,0,len));
            is.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
