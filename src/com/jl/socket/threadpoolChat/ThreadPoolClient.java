package com.jl.socket.threadpoolChat;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName ThreadPoolClient
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/3/22 15:33
 * @Version 1.0
 */
public class ThreadPoolClient {
    public static void main(String[] args){
        try {
            Socket s = new Socket("127.0.0.1",12345);
            BufferedReader bufferedReader = null;
            BufferedWriter bufferedWriter = null;
            try {
                bufferedReader  = new BufferedReader(new InputStreamReader(System.in));
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

                while(true){
                    String data = bufferedReader.readLine();
                    bufferedWriter.write(data);
                    bufferedWriter.write("\n");
                    bufferedWriter.flush();
//                    s.shutdownOutput();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
