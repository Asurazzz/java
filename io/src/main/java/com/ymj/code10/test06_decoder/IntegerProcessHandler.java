package com.ymj.code10.test06_decoder;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 首先，需要将其加入到通道的流水线中。其次，由于解码器的功能仅仅是完成ByteBuf
 * 的解码，不做其他的业务处理，所以还需要编写一个业务处理器，用于在读取解码后的
 * Java POJO对象后，完成具体的业务处理。
 */
public class IntegerProcessHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Integer integer = (Integer) msg;
        System.out.println("打印出一个整数: " + integer);
    }
}
