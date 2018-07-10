package cn.guxiangfly.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * TestBlockingNIO
 *
 * @author guxiang
 * @date 2017/11/2
 */
public class TestBlockingNIO {

    public static void main(String[] args) throws IOException {
        new TestBlockingNIO().client();
    }


    @Test
    public void client() throws IOException{
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8889));

        //4 用通道读取本地文件给发出去
        FileChannel inChannel = FileChannel.open(Paths.get("D:\\Everything-1.4.1.877.x64.zip"), StandardOpenOption.READ);

        ByteBuffer buf= ByteBuffer.allocate(1024);

        //3. 读取本地文件，并发送到服务端
        while (inChannel.read(buf)!=-1){

            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }

        //5 关闭通道
        inChannel.close();
        socketChannel.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();


        //6 用通道写入接收到的文件存储到本地
        FileChannel outChannel = FileChannel.open(Paths.get("D:\\Everything-1.4.1.877.x64-2.zip"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //绑定端口
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",8889));

        //获取客户端链接的通道
        SocketChannel socketChannel= serverSocketChannel.accept();

        //分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //接收客户端的数据并且保存到本地
        while (socketChannel.read(buf) !=-1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        //关闭通道
        serverSocketChannel.close();
        outChannel.close();
        socketChannel.close();
    }
}
