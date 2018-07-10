package cn.guxiangfly.shiyan.kaoshi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class clent {

    /**
     * @param args
     * @throws IOException 
     * @throws UnknownHostException 
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        //创建socket
        Socket s=new Socket("192.168.1.103",10000);
        
        //创建读取对象
        BufferedReader bufr=new BufferedReader(new FileReader("1.txt"));
        
        //创建写入对象
        PrintWriter pw=new PrintWriter(s.getOutputStream(), true);
        
        String line=null;
        
        
        while((line=bufr.readLine())!=null)
        {
            pw.println(line);
        }
        //告诉服务端，发送完成
        s.shutdownOutput();
        
        //接收返回数据
        BufferedReader bfr=new BufferedReader(new InputStreamReader(s.getInputStream()));
        String text=bfr.readLine();
        System.out.println(text);
        
        bfr.close();
        bufr.close();
        s.close();

    }

}