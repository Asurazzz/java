package com.ymj.code01_socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname ServerDemo
 * @Description 服务端代码
 * @Date 2021/7/20 17:17
 * @Created by yemingjie
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建一个线程池,如果有客户端连接就创建一个线程, 与之通信
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 2.创建socket对象
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器已启动！");
        while (true) {
            // 3.监听客户端
            Socket socket = serverSocket.accept();
            System.out.println("有客户端连接！");
            // 4.开启新的线程处理
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    handle(socket);
                }

            });
        }
    }

    public static void handle(Socket socket) {
        try (InputStream is = socket.getInputStream();
             OutputStream os = socket.getOutputStream();){
            //从连接中取出输入流来接收消息
            byte[] b = new byte[1024];
            int read = is.read(b);
            System.out.println("客户端：" + new String(b, 0, read));
            // 连接中取出输出流并回话
            os.write("hello".getBytes(StandardCharsets.UTF_8));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
