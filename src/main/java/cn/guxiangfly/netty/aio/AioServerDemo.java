package cn.guxiangfly.netty.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;

/**
 * AioServerDemo
 *
 * @author guxiang
 * @date 2018/1/6
 */
public class AioServerDemo {
    public static void startServer() throws Exception{
        AsynchronousServerSocketChannel asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();

        asynchronousServerSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Void attachment) {
                try {
                    operate(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Void attachment) {

            }
        });
    }


    public static void operate(AsynchronousSocketChannel channel) throws Exception {
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        Integer size = channel.read(byteBuffer).get();
        while (size>0){
            byteBuffer.flip();
            Charset charset = Charset.forName("UTF-8");
            System.out.println(charset.newDecoder().decode(byteBuffer).toString());
        }

        channel.close();
    }
}
