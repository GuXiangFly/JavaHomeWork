package cn.guxiangfly.shiyan.kaoshi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(10000);
        
        Socket s=ss.accept();
        
        BufferedReader bufr=new BufferedReader(new InputStreamReader(s.getInputStream()));
        
        BufferedWriter bufw=new BufferedWriter(new FileWriter("2.txt"));
        
        String line=null;
        
        while((line=bufr.readLine())!=null)
        {
            bufw.write(line);
            bufw.newLine();
            bufw.flush();
        }
        
        PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
        
        pw.println("完成");
        
        pw.close();
        bufw.close();
        bufr.close();
        s.close();
        ss.close();

    }

}