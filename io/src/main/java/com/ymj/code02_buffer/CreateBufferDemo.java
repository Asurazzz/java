package com.ymj.code02_buffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @Classname CreateBufferDemo
 * @Description TODO
 * @Date 2021/8/5 17:33
 * @Created by yemingjie
 */
public class CreateBufferDemo {
    public static void main(String[] args) {
        //1.创建一个指定长度的缓冲区, 以ByteBuffer为例
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        for (int i = 0; i < 5; i++) {
            System.out.println(byteBuffer.get());
        }

        // 在此调用会报错--后续再读缓冲区时着重讲解
        // System.out.println(byteBuffer.get());
        // 2.创建一个有内容的缓冲区
        ByteBuffer wrap = ByteBuffer.wrap("hello".getBytes(StandardCharsets.UTF_8));
        for (int i = 0; i < 5; i++) {
            System.out.println(wrap.get());
        }
    }
}
