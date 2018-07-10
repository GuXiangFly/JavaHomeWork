package cn.guxiangfly.shiyan.kaoshi;

import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * SocketTest
 *
 * @author guxiang
 * @date 2018/1/1
 */
public class SocketTest {

    @Test
    public void testServer() throws Exception {
        String str = "lingyingggang";
        DatagramSocket datagramSocket = new DatagramSocket();
        DatagramPacket packet= new DatagramPacket(str.getBytes(),str.getBytes().length, InetAddress.getByName("127.0.0.1"),6666);
        datagramSocket.send(packet);
        datagramSocket.close();
    }

    @Test
    public void testClient() throws Exception{
        DatagramSocket socket = new DatagramSocket(6666);
        DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
        socket.receive(packet);
        byte[] data = packet.getData();
        int length = packet.getLength();
        System.out.println(new String(data,0,length));
        socket.close();
    }
}
