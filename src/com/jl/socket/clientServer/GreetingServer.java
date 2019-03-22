package com.jl.socket.clientServer;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName GreetingServer
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/3/17 21:37
 * @Version 1.0
 */
public class GreetingServer extends Thread {
    private ServerSocket serverSocket;

    public GreetingServer(int port) {
        try {
            this.serverSocket = new ServerSocket(54321);
//            this.serverSocket.setSoTimeout(10000);
        } catch (IOException e) {
            e.printStackTrace();
            this.serverSocket = null;
        }
    }

    public void run(){
        DataInputStream in = null;
        BufferedInputStream bin = null;
        DataOutputStream out = null;
        BufferedOutputStream bout = null;
        while (true){
            try {
                System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
                Socket server = this.serverSocket.accept();
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
                bin = new BufferedInputStream(server.getInputStream());
                bout = new BufferedOutputStream(server.getOutputStream());
//                bout.write(("谢谢连接我:" + server.getLocalSocketAddress() + "\nGoodbye!").getBytes("UTF-8"));
//                bout.flush();
//                server.shutdownOutput();//socket关闭输出
                int t = -1;
                byte[] bytes = new byte[8];
                int rlen = -1;
                while((rlen = bin.read(bytes))!=-1){
                    System.out.print(new String(bytes,0,rlen,"UTF-8"));
                }
                server.close();
                System.out.println("结束");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(in != null){
                        in.close();
                    }
                    if(out != null){
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args){
        try {
            Thread t= new GreetingServer(54321);
            t.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
