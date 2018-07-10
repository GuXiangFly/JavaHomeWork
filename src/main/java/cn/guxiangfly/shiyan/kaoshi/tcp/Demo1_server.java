package cn.guxiangfly.shiyan.kaoshi.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Demo1_server
 *
 * @author guxiang
 * @date 2018/1/3
 */
public class Demo1_server {

    public static void main(String[] args) throws IOException {
        ServerSocket server= new ServerSocket(12345);

        Socket socket= server.accept();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("百度一下,你就知道".getBytes());

        byte[] arr = new byte[1024];
        int len = inputStream.read(arr);
        System.out.println(new String(arr,0,len));
    }
}
