package com.ymj.code09_test05_bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class WriteReadTest {
    public static void main(String[] args) {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(9, 100);
        System.out.println("动作：分配 ByteBuf(9, 100) --->" +  buffer);
        buffer.writeBytes(new byte[]{1, 2, 3, 4});
        System.out.println("动作：写入 4 个字节 (1,2,3,4) --->" +  buffer);
        System.out.println("start==========:get==========");
        getByteBuf(buffer);
        System.out.println("动作：取数据 ByteBuf ---->" + buffer);
        System.out.println("start==========:read==========");
        readByteBuf(buffer);
        System.out.println("动作：读完 ByteBuf ---->" + buffer);
    }

    /**
     * 读字节不改变指针
     * @param buffer
     */
    private static void getByteBuf(ByteBuf buffer) {
        for (int i = 0; i < buffer.readableBytes(); i++) {
            System.out.println("读一个字节:" + buffer.getByte(i));
        }
    }

    /**
     * 取字节
     * @param buffer
     */
    private static void readByteBuf(ByteBuf buffer) {
        while (buffer.isReadable()) {
            System.out.println("取一个字节:" + buffer.readByte());
        }
    }
}
