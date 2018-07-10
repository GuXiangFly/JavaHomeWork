package cn.guxiangfly.netty.demo;


import org.jboss.netty.channel.*;

/**
 * HelloHandler
 *
 * @author guxiang
 * @date 2018/1/18
 */
public class HelloHandler extends SimpleChannelHandler {

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        System.out.println(e.getMessage());

        /*//回写数据
        ChannelBuffer copidBuffer = ChannelBuffers.copiedBuffer("hi".getBytes());
        ctx.getChannel().write(copidBuffer);*/

        ctx.getChannel().write("hi");
        super.messageReceived(ctx, e);
    }

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channel Connected");
        super.channelConnected(ctx, e);
    }

    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channel disconnect");
        super.channelDisconnected(ctx, e);
    }

    /**
     * channel 关闭的时候触发
     * @param ctx
     * @param e
     * @throws Exception
     */
    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channel close");
        super.channelClosed(ctx, e);
    }
}
