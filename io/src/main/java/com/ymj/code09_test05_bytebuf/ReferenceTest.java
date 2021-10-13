package com.ymj.code09_test05_bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class ReferenceTest {
    public static void main(String[] args) {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer();
        System.out.println("after create:" + buffer.refCnt());

        //增加一次引用计数
        buffer.retain();
        System.out.println("after retain:" + buffer.refCnt());

        //减少一次引用计数
        buffer.release();
        System.out.println("after release:" + buffer.refCnt());

        //减少一次引用计数
        buffer.release();
        System.out.println("after release:" + buffer.refCnt());

        //错误:refCnt: 0,不能再 retain
        //增加一次引用计数, 会报错
        // 最后一次retain方法抛出了IllegalReferenceCountException异常。原
        //因是：在此之前，缓冲区buffer的引用计数已经为0，不能再retain了。也就是说：在Netty
        //中，引用计数为0的缓冲区不能再继续使用。
        buffer.retain();
        System.out.println("after retain:" + buffer.refCnt());
    }
}
