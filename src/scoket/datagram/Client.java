package scoket.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        ds.setSoTimeout(0);
        ds.connect(InetAddress.getByName("192.168.100.110"), 7777); // 连接指定服务器和端口
// 发送:
        byte[] data = "Hello".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length);
        ds.send(packet);
// 接收:
        byte[] buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
        while (true) {
            ds.receive(packet);
            String resp = new String(packet.getData(), packet.getOffset(), packet.getLength());
            System.out.println(resp);
            ds.disconnect();
        }
    }

}
