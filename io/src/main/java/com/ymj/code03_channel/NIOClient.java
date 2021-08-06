package com.ymj.code03_channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @Classname NIOClient
 * @Description TODO
 * @Date 2021/8/6 15:44
 * @Created by yemingjie
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        // 1. 打开通道
        SocketChannel socketChannel = SocketChannel.open();
        // 2.设置连接IP和端口号
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));
        //3.写出数据
        socketChannel.write(ByteBuffer.wrap("hello".getBytes(StandardCharsets.UTF_8)));
        //4.读取服务器写回的数据
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int read = socketChannel.read(readBuffer);
        System.out.println("服务端消息:" + new String(readBuffer.array(), 0, read, StandardCharsets.UTF_8));
        //5.释放资源
        socketChannel.close();

    }
}
