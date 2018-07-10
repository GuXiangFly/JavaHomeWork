package cn.guxiangfly.shiyan.project04;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    boolean started = false;
    ServerSocket ss = null;

    public List<Client> clients = new ArrayList<Client>();

    public static void main(String[] args) {
        new ChatServer().start();
    }

    public void start() {
        try {
            ss = new ServerSocket(8787);
            started = true;
        } catch (BindException e) {
            System.out.println("端口使用中....");
            System.out.println("请关掉相关程序并重新运行服务器！");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        class Client implements Runnable {
            private Socket s;
            private DataInputStream dis = null;
            private DataOutputStream dos = null;
            private boolean bConnected = false;

            public Client(Socket s) {
                this.s = s;
                try {
                    dis = new DataInputStream(s.getInputStream());
                    dos = new DataOutputStream(s.getOutputStream());
                    bConnected = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            /*
           数据的读写
             */
            public void send(String str) {
                try {
                    dos.writeUTF(str);
                } catch (IOException e) {
                    clients.remove(this);
                    System.out.println("对方退出了！我从List里面去掉了！");
                    //e.printStackTrace();
                }
            }

            @Override
            public void run() {
                try {
                    while (bConnected) {
                        String str = dis.readUTF();
                        System.out.println(str);
                        for (int i = 0; i < clients.size(); i++) {
                             cn.guxiangfly.shiyan.project04.Client c = clients.get(i);
                            //c.send(str);
                        }
                        }
                    } catch(EOFException e){
                        System.out.println("Client closed!");
                    } catch(IOException e){
                        e.printStackTrace();
                    } finally{
                        try {
                            if (dis != null) {
                                dis.close();
                            }
                            if (dos != null) {
                                dos.close();
                            }
                            if (s != null) {
                                s.close();
                                //s = null;
                            }

                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }


                    }
                }

            }
        }

}

