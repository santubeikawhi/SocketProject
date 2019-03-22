package com.jl.socket.chatClientServer;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 最简单的聊天系统 （服务器与客户端之间）
 * @ClassName ChatClient
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/3/22 9:58
 * @Version 1.0
 */
public class ChatClient {
    public static void main(String[] args){
        try {
            Socket s = new Socket("127.0.0.1",12345);
            OutputStream os = s.getOutputStream();
            InputStream is  = new BufferedInputStream(System.in);
            while (true){
                byte[] buffer = new byte[1024];
                int len = -1;
                len = is.read(buffer);
                os.write(buffer);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
