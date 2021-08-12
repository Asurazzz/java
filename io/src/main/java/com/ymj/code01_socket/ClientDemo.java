package com.ymj.code01_socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Classname ClientDemo
 * @Description TODO
 * @Date 2021/7/20 17:29
 * @Created by yemingjie
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        while (true) {
            // 1.创建socket对象
            Socket socket = new Socket("127.0.0.1", 9999);
            // 2.从连接中取出输出流并发消息
            OutputStream os = socket.getOutputStream();
            System.out.println("请输入:");
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            os.write(msg.getBytes(StandardCharsets.UTF_8));
            // 3.从连接中取出输入流并接收回话
            InputStream is = socket.getInputStream();
            byte[] b = new byte[1024];
            int read = is.read(b);
            System.out.println("ClientDemo ：" + new String(b, 0, read).trim());
            // 4.关闭
            socket.close();
        }
    }
}