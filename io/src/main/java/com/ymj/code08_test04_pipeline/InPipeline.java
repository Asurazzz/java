package com.ymj.code08_test04_pipeline;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;

/**
 * 将新建三个极为简单的入站处理器，三个入站
 * 处理器分别为：SimpleInHandlerA、SimpleInHandlerB、SimpleInHandlerC。在
 * ChannelInitializer初始化处理器的initChannel方法中，把它们加入到流水线中。
 */
public class InPipeline {
    /**
     * 内部类：第一个入站处理器
     */
    static class SimpleInHandlerA extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("入站处理器A: 被回调 ");
            super.channelRead(ctx, msg);
        }
    }

    /**
     * 内部类：第二个入站处理器
     */
    static class SimpleInHandlerB extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("入站处理器B: 被回调 ");
            super.channelRead(ctx, msg);
        }
    }

    /**
     * 内部类：第二个入站处理器
     */
    static class SimpleInHandlerC extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("入站处理器C: 被回调 ");
            super.channelRead(ctx, msg);
        }
    }

    public static void main(String[] args) {
        ChannelInitializer i = new ChannelInitializer<EmbeddedChannel>() {

            @Override
            protected void initChannel(EmbeddedChannel ch) throws Exception {
                ch.pipeline().addLast(new SimpleInHandlerA());
                ch.pipeline().addLast(new SimpleInHandlerB());
                ch.pipeline().addLast(new SimpleInHandlerC());
            }
        };
        EmbeddedChannel channel = new EmbeddedChannel(i);
        ByteBuf buf = Unpooled.buffer();
        buf.writeInt(1);
        // 向通道写一个入站报文（数据包）
        channel.writeInbound(buf);
    }
}
