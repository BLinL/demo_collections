package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8000));
        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.clear();
        buf.put(newData.getBytes());

        buf.flip();

        byte[] bytes = new byte[1024];
        while(true){
            System.out.println("请输入");
            System.in.read(bytes);
            buf = ByteBuffer.wrap(bytes);
            socketChannel.write(buf);
            buf.clear();
        }

    }
}
