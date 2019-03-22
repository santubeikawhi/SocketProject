package com.jl.socket.clientServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName TestClient
 * @Description TODO
 * @Author Jiangl
 * @Date 2019/3/22 9:40
 * @Version 1.0
 */
public class TestClient {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("127.0.0.1",12345);
            OutputStream os = socket.getOutputStream();
            os.write("dasdfasdf".getBytes());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
