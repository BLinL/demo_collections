package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioServer {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//        ServerSocket server = serverSocketChannel.socket();
        serverSocketChannel.bind(new InetSocketAddress(8000));

        System.out.println("server start at 8000:");
        ByteBuffer buffer = ByteBuffer.allocate(512);
        byte[] ss = new byte[1];
        while (true){
            SocketChannel t = serverSocketChannel.accept();
//            t.configureBlocking(false);
            System.out.println("incoming from:" + t.getRemoteAddress());
            System.out.println("isBlocking:" + t.isBlocking());

            if(t!=null){
                while ((t.read(buffer)) != -1){
                   buffer.flip();
                    while (buffer.hasRemaining()){
                        buffer.get(ss);
                        System.out.print(new String(ss,"utf-8"));
                    }
                    buffer.clear();
                }
            }
        }
    }
}
