package com.jl.socket.chatClientServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 最简单的聊天系统 （服务器与客户端之间）
 * @ClassName ChatServer
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/3/22 9:58
 * @Version 1.0
 */
public class ChatServer {
    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(12345);
            Socket s = ss.accept();
            InputStream is = s.getInputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while((len = is.read(buffer))!=-1){
                System.out.println(new String(buffer,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
