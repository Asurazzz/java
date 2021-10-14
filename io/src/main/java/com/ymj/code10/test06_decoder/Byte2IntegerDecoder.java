package com.ymj.code10.test06_decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 首先，Byte2IntegerDecoder解码器继承自ByteToMessageDecode，实现其decode方法；
 * 其次，在decode方法中，通过ByteBuf的readInt( )实例方法，从输入缓冲区读取到整
 * 数，其作用是将二进制数据解码成一个一个的整数；
 * 再次，将解码后的整数增加decode方法的List<Object>列表参数中；最后，decode不断
 * 地循环解码，并且不断地添加到List<Object>结果容器中。
 */
public class Byte2IntegerDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        while (in.readableBytes() >= 4) {
            int i = in.readInt();
            System.out.println("解码出一个整数: " + i);
            out.add(i);
        }
    }
}
