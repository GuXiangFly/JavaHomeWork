package cn.guxiangfly.shiyan.kaoshi.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Demo1_client
 *
 * @author guxiang
 * @date 2018/1/3
 */
public class Demo1_client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1",12345);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));

        outputStream.write("挖掘机哪家强".getBytes());
        socket.close();
    }
}
