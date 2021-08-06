package com.ymj.code03_channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @Classname NIOServer
 * @Description TODO
 * @Date 2021/8/6 11:21
 * @Created by yemingjie
 */
public class NIOServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 1.打开一个服务端通道
        ServerSocketChannel server = ServerSocketChannel.open();
        // 2.绑定对应的端口
        server.bind(new InetSocketAddress(9999));
        // 3.端口默认是阻塞的，设置为非阻塞
        // true为阻塞，false为非阻塞
        server.configureBlocking(false);
        System.out.println("服务器端启动成功.............");
        while (true) {
            // 4. 检查是否有客户端连接 有客户端连接会返回对应的通道 , 否则返回null
            SocketChannel socketChannel = server.accept();
            if (socketChannel == null) {
                System.out.println("没有客户端连接...我去做别的事情");
                Thread.sleep(2000);
                continue;
            }
            // 5. 获取客户端传递过来的数据,并把数据放在byteBuffer这个缓冲区中
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //返回值:
            // 正数: 表示本次读到的有效字节个数.
            // 0 : 表示本次没有读到有效字节.
            // -1 : 表示读到了末尾
            int read = socketChannel.read(byteBuffer);
            System.out.println("客户端消息:" + new String(byteBuffer.array(), 0, read, StandardCharsets.UTF_8));
            // 6. 给客户端回写数据
            socketChannel.write(ByteBuffer.wrap("你好".getBytes(StandardCharsets.UTF_8)));
            // 7. 释放资源
            socketChannel.close();
        }

    }
}
