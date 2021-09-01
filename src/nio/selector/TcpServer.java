package nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author bliu
 * @date 2021-03-25 11:29
 */
public class TcpServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ByteBuffer resp = ByteBuffer.wrap("hello ".getBytes(StandardCharsets.UTF_8));

        //open 静态工厂创建ServerSocketChannel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ServerSocket serverSocket = ssc.socket();
        serverSocket.bind(new InetSocketAddress(12000));
        //设置非阻塞模式
        ssc.configureBlocking(false);

        Selector selector = Selector.open();
        /**
         * interests
         * 1. SelectionKey.OP_CONNECT
         * 2. SelectionKey.OP_ACCEPT
         * 3. SelectionKey.OP_READ
         * 4. SelectionKey.OP_WRITE
         */
        SelectionKey selectionKey = ssc.register(selector, SelectionKey.OP_ACCEPT);

        try {
            while(true) {
                int readyChannels = selector.select();
                if(readyChannels == 0) continue;

                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
                while(keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    if(key.isAcceptable()) {
                        System.out.println("Accepting connection!");

                        ServerSocketChannel sch = (ServerSocketChannel) key.channel();
                        SocketChannel ch = sch.accept();
                        ch.configureBlocking(false);
                        ch.register(selector, SelectionKey.OP_READ);
                    }else if(key.isWritable()) {
                        System.out.println("sending response");
                        SocketChannel sc = (SocketChannel)key.channel();
                        sc.write(resp);
                        resp.rewind();
                    }else if(key.isReadable()) {
                        System.out.println("Accepting command!");
                        SocketChannel ch = (SocketChannel) key.channel();
                        ByteBuffer buf = ByteBuffer.allocate(200);
                        ch.read(buf);
                        buf.flip();
                        Charset charset = Charset.forName("UTF-8");
                        CharsetDecoder decoder = charset.newDecoder();
                        CharBuffer cbuf = decoder.decode(buf);
                        System.out.println("receive from client:"+cbuf.toString());
                    }
                    keyIterator.remove();
                }
            }
        }finally {
            ssc.close();
        }
    }
}
