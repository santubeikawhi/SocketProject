package com.jl.socket.threadChat;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程下socket编程
 * @ClassName ThreadServer
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/3/22 10:52
 * @Version 1.0
 */
public class ThreadServer {
    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(12345);
            while (true){
                Socket s = ss.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        InputStream is = null;
                        try {
                            is = s.getInputStream();
                            byte[] buffer = new byte[1024];
                            int len =-1;
                            while((len =is.read(buffer)) !=-1){
                                System.out.println(new String(buffer,0,len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
