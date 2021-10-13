package com.ymj.code09_test05_bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class BufferTypeTest {
    final static Charset UTF_8 = Charset.forName("UTF-8");


    public static void main(String[] args) {
        testHeapBuffer();
        testDirectBuffer();
    }

    /**
     * 堆缓冲区测试用例
     */
    public static void testHeapBuffer() {
        // 取得堆内存
        ByteBuf heapBuf = ByteBufAllocator.DEFAULT.heapBuffer();
        heapBuf.writeBytes("学习学习学习学习学习".getBytes(StandardCharsets.UTF_8));
        if (heapBuf.hasArray()) {
            // 取得内部数组
            byte[] array = heapBuf.array();
            int offset = heapBuf.arrayOffset() + heapBuf.readerIndex();
            int length = heapBuf.readableBytes();
            System.out.println(new String(array, offset, length, UTF_8));
        }
        heapBuf.release();
    }

    /**
     * 直接缓冲区测试用例
     */
    public static void testDirectBuffer() {
        ByteBuf directBuf = ByteBufAllocator.DEFAULT.directBuffer();
        directBuf.writeBytes("学习学习学习学习学习".getBytes(StandardCharsets.UTF_8));
        if (!directBuf.hasArray()) {
            int length = directBuf.readableBytes();
            byte[] array = new byte[length];
            // 把数据读取到堆内存 array 中，再进行 Java 处理
            directBuf.getBytes(directBuf.readerIndex(), array);
            System.out.println(new String(array, UTF_8));
        }
        directBuf.release();
    }
}
