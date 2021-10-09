package com.ymj.code05_test01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.logging.Logger;


public class NioDiscardServer {
    public static void main(String[] args) throws Exception{
        startServer();
    }

    public static void startServer() throws Exception {
        // 获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 绑定连接
        serverSocketChannel.bind(new InetSocketAddress(18899));
        System.out.println("服务器启动成功");

        // 获取选择器
        Selector selector = Selector.open();
        // 将通道注册的“接收新连接”IO 事件，注册到选择器上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 轮询感兴趣的 IO 就绪事件（选择键集合）
        while (selector.select() > 0) {
            // 获取选择键集合
            Iterator<SelectionKey> selectedKeys = selector.selectedKeys().iterator();
            while (selectedKeys.hasNext()) {
                // 获取单个的选择键，并处理
                SelectionKey selectedKey = selectedKeys.next();
                // 判断 key 是具体的什么事件
                if (selectedKey.isAcceptable()) {
                    // 若选择键的 IO 事件是“连接就绪”事件,就获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    // 将新连接切换为非阻塞模式
                    socketChannel.configureBlocking(false);
                    // 将该新连接的通道的可读事件，注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectedKey.isReadable()){
                    // 若选择键的 IO 事件是“可读”事件, 读取数据
                    SocketChannel socketChannel =
                            (SocketChannel) selectedKey.channel();
                    // 读取数据，然后丢弃
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int length = 0;
                    while ((length = socketChannel.read(byteBuffer)) > 0) {
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, length));
                        byteBuffer.clear();
                    }
                    socketChannel.close();
                }
                // 移除选择键
                selectedKeys.remove();
            }
        }
        // 关闭连接
        serverSocketChannel.close();
    }
}
