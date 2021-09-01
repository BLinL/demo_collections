package nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author bliu
 * @date 2021-03-25 11:54
 */
public class TcpClient {
    public static void main(String[] args) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(200);

        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        sc.connect(new InetSocketAddress("localhost",12000));

//        while(!sc.finishConnect()) {
//            System.out.println("-----------");
//        }
        Selector secector = Selector.open();
        // selectableChannel 可以注册到一个选择器上
        sc.register(secector, SelectionKey.OP_CONNECT);
        try {
            while(true) {
                while(secector.select() > 0) {
                    Set<SelectionKey> selectionKeys = secector.selectedKeys();
                    Iterator<SelectionKey> it = selectionKeys.iterator();
                    while(it.hasNext()) {
                        SelectionKey key = it.next();
                        if(key.isReadable()) {
                            ReadableByteChannel ch = (ReadableByteChannel) key.channel();
                            while(ch.read(buf) > 0){

                            }

                            buf.flip();
                            Charset charset =Charset.forName("UTF-8");
                            CharBuffer charbuf = charset.newDecoder().decode(buf);
                            System.out.println(charbuf.toString());
                        }else if(key.isConnectable()) {
                            SocketChannel ch = (SocketChannel) key.channel();
                            if (ch.finishConnect()) {
                                System.out.println("connected to ");
                                key.interestOps(key.interestOps() ^ SelectionKey.OP_CONNECT);
                                key.interestOps(key.interestOps() | SelectionKey.OP_WRITE);
                            }
                        }else if(key.isWritable()){
                            System.out.println("write welcom message");

                            WritableByteChannel ch = (WritableByteChannel)key.channel();
                            ByteBuffer writeBuf = ByteBuffer.wrap("Hi I am client".getBytes());
                            while(writeBuf.hasRemaining()) {
                                ch.write(writeBuf);
                            }


                            if (writeBuf.remaining() == 0) {
                                key.interestOps(key.interestOps() ^ SelectionKey.OP_WRITE);
                            }
                        }
                    }
                }
            }
        }finally {
            sc.close();
        }
    }
}
