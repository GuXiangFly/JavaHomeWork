package cn.guxiangfly.shiyan.kaoshi.tcp;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Test2_UpdateServer
 *
 * @author guxiang
 * @date 2018/1/4
 */
public class Test2_UpdateServer {

    @Test
    public void server() throws Exception{
        ServerSocket server = new ServerSocket(12345);
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        byte[] arrs = new byte[1024];
        int read = inputStream.read(arrs);
        String filename=  new String(arrs,0,read);
        System.out.println(filename);

        FileOutputStream fos =  new FileOutputStream(filename);
        int data;
        while ((data= inputStream.read())!=-1){
            fos.write(data);
        }
        inputStream.close();
        socket.close();
    }

    @Test
    public void client() throws Exception{
        Socket socket = new Socket("127.0.0.1",12345);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        byte[] arr = new byte[1024];
        outputStream.write(line.getBytes());
        outputStream.close();

    }

    public static void main(String[] args) {
        try {
            new Test2_UpdateServer().client();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
