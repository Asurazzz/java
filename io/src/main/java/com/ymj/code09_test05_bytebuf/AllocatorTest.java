package com.ymj.code09_test05_bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;

public class AllocatorTest {
    public static void main(String[] args) {
        ByteBuf buffer = null;
        //方法 1：通过默认分配器分配
        //初始容量为 9，最大容量 100 的缓冲区
        buffer = ByteBufAllocator.DEFAULT.buffer(9, 100);

        //方法 2：通过默认分配器分配
        //初始容量为 256，最大容量 Integer.MAX_VALUE 的缓冲区
        buffer = ByteBufAllocator.DEFAULT.buffer();

        //方法 3：非池化分配器，分配 Java 的堆（Heap）结构内存缓冲区
        buffer = UnpooledByteBufAllocator.DEFAULT.heapBuffer();

        //方法 4：池化分配器，分配由操作系统管理的直接内存缓冲区
        buffer = PooledByteBufAllocator.DEFAULT.directBuffer();
    }
}
