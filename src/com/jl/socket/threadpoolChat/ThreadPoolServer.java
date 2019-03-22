package com.jl.socket.threadpoolChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadPoolServer
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/3/22 15:32
 * @Version 1.0
 */
public class ThreadPoolServer {
    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(12345);
            ExecutorService executorService = Executors.newFixedThreadPool(1000);
            while(true){
                Socket s = ss.accept();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        BufferedReader reader = null;
                        try {
                            reader = new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
                            String inputString;
                            while((inputString = reader.readLine()) != null){
                                System.out.println("客户端"+s.getRemoteSocketAddress()+"说："+inputString);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                if(reader != null){
                                    reader.close();
                                }
                                s.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
                executorService.execute(runnable);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
