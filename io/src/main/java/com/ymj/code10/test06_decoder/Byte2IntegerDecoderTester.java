package com.ymj.code10.test06_decoder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;

/**
 * 新建了一个EmbeddedChannel嵌入式通道实例，将两个自己的入站处
 * 理器Byte2IntegerDecoder和IntegerProcessHandler加入通道的流水线上。
 *
 *
 * 请注意先后次序：Byte2IntegerDecoder解码器在前、IntegerProcessHandler整数处理器
 * 在后。为什么呢？因为入站处理的次序为——从前到后。
 * 为了测试入站处理器，需要确保通道能接收到ByteBuf入站数据。这里调用
 * writeInbound方法，模拟入站数据的写入，向嵌入式通道EmbeddedChannel写入100次
 * ByteBuf入站缓冲；每一次写入仅仅包含一个整数。模拟入站数据，会被流水线上的两个入
 * 站处理器所接收和处理。接着，这些入站的二进制字节被解码成一个一个的整数，然后逐
 * 个地输出到控制台上。
 */
public class Byte2IntegerDecoderTester {


    public static void main(String[] args) {
        ChannelInitializer i = new ChannelInitializer<EmbeddedChannel>() {

            @Override
            protected void initChannel(EmbeddedChannel ch) throws Exception {
                ch.pipeline().addLast(new Byte2IntegerDecoder());
                ch.pipeline().addLast(new IntegerProcessHandler());
            }
        };

        EmbeddedChannel channel = new EmbeddedChannel(i);
        for (int j = 0; j < 100; j++) {
            ByteBuf buf = Unpooled.buffer();
            buf.writeInt(j);
            channel.writeInbound(buf);
        }
    }
}
