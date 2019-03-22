package com.jl.socket.clientServer;


import java.io.*;
import java.net.Socket;

/**
 * @ClassName GreetingClient
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/3/17 21:37
 * @Version 1.0
 */
public class GreetingClient {
    public static void main(String[] args){
        String serverName = "127.0.0.1";
        int port = 54321;
        DataInputStream in = null;
        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;
        DataOutputStream out = null;
        try {
            System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
            Socket client = new Socket(serverName,port);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
//            out = new DataOutputStream(client.getOutputStream());
            bout = new BufferedOutputStream(client.getOutputStream());
            bin = new BufferedInputStream(client.getInputStream());
            String outStr = "Hello from " + client.getLocalSocketAddress()+"\n";
//            out.writeUTF(outStr);
            bout.write(outStr.getBytes("UTF-8"));
            bout.flush();
            client.shutdownOutput();
            int len = -1;
            byte[] bytes = new byte[8];
            while ((len = bin.read(bytes))!=-1){
                System.out.print(new String(bytes,0,len,"UTF-8"));
            }
            client.close();
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
