package com.jl.socket.threadChat;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 多线程下socket编程
 * @ClassName ThreadClient
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/3/22 10:52
 * @Version 1.0
 */
public class ThreadClient {
    public static void main(String[] args){
        try {
            Socket s = new Socket("127.0.0.1",12345);
            OutputStream os = s.getOutputStream();
            InputStream is = new BufferedInputStream(System.in);
            while (true){
                byte[] buffer = new byte[1024];
                int len = -1;
                len = is.read(buffer);
                os.write(buffer);
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
