package com.ymj.code06_test02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class NioReceiveServer {
    /**
     *  接受文件路径
     */
    private static final String  RECEIVE_PATH = NioDemoConfig.SOCKET_RECEIVE_PATH;

    private Charset charset = Charset.forName("UTF-8");

    /**
     * 服务器端保存的客户端对象，对应一个客户端文件
     */
    static class Client {
        // 文件名称
        String fileName;
        // 长度
        long fileLength;
        // 开始传输的时间
        long startTime;
        // 客户端的地址
        InetSocketAddress remoteAddress;
        // 输出的文件通道
        FileChannel outChannel;
        // 接收长度
        long receiveLength;

        public boolean isFinished() {
            return receiveLength >= fileLength;
        }
    }

    private ByteBuffer buffer = ByteBuffer.allocate(NioDemoConfig.SERVER_BUFFER_SIZE);
    // 使用 Map 保存每个客户端传输
    // 当 OP_READ 通道可读时，根据 channel 找到对应的对象
    Map<SelectableChannel, Client> clientMap = new HashMap<>();
    public void startServer() throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverChannel.socket();

        serverChannel.configureBlocking(false);
        // 4、绑定连接
        InetSocketAddress address = new InetSocketAddress(18899);
        serverSocket.bind(address);

        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("serverChannel is linstening...");

    }
}
