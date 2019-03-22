package com.jl.socket.tclass;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

/**
 * @ClassName TestSocketServer
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/3/13 20:48
 * @Version 1.0
 */
public class TestSocketServer {
    public static void printSocketServer(ServerSocket serverSocket){
        System.out.println("返回此套接字在其侦听上的hostAddress："+serverSocket.getInetAddress().getHostAddress());
        System.out.println("返回此套接字在其侦听上的hostName："+serverSocket.getInetAddress().getHostName());
        System.out.println("返回此套接字在其侦听上的address："+serverSocket.getInetAddress().getAddress());
        System.out.println("返回此套接字在其侦听上的CanonicalHostName："+serverSocket.getInetAddress().getCanonicalHostName());
        System.out.println("返回此套接字在其侦听上的端口："+serverSocket.getLocalPort());
    }

    public static void main(String[] args){
        try {
            //服务器应用通过java.net.ServerSocket类以获取一个端口，并且侦听客户端请求。
            //创建绑定到特定端口的服务器套接字
            ServerSocket socketServerport = new ServerSocket(54321);
            printSocketServer(socketServerport);
            System.out.println("");
            //利用指定的backlog创建服务器套接字并将其绑定在特定的本地端口
            ServerSocket serverSocketbacklogport = new ServerSocket(54322,12345);
            printSocketServer(serverSocketbacklogport);
            System.out.println("");
            //使用指定端口，侦听的backlog和要绑定的本地ip地址创建服务器
            InetAddress inetAddress = InetAddress.getLocalHost();
            ServerSocket backlogportAddress = new ServerSocket(54323,12346,inetAddress);
            printSocketServer(backlogportAddress);
            System.out.println("");
            //创建非绑定套接字
            ServerSocket serverSocket = new ServerSocket();
            printSocketServer(serverSocket);
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
