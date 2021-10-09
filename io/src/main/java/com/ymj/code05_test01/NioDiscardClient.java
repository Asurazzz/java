package com.ymj.code05_test01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class NioDiscardClient {
    public static void main(String[] args) throws IOException {
        startClient();
    }

    private static void startClient()  throws IOException{
        InetSocketAddress address = new InetSocketAddress(
                "127.0.0.1", 18889);
        // 获取通道
        SocketChannel socketChannel = SocketChannel.open();
        // 切换成非阻塞模式
        socketChannel.configureBlocking(false);
        // 不断地自旋、等待连接完成，或者做一些其他的事情
        // while (!socketChannel.finishConnect()) {}
        socketChannel.connect(address);
        System.out.println("客户端连接成功");
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("hello world".getBytes(StandardCharsets.UTF_8));
        byteBuffer.flip();
        // 发送到服务器
        socketChannel.write(byteBuffer);
        socketChannel.shutdownOutput();
        socketChannel.close();
    }
}
