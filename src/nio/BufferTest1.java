package nio;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author bliu
 * @date 2021-03-16 9:46
 */
public class BufferTest1 {
    public static void main(String[] args) {
        byte[] bytes = new byte[]{1, 2, 3, 4};
        ByteBuffer buf = ByteBuffer.wrap(bytes);
        buf.put((byte)'a');
        buf.put((byte)'b');
        buf.put((byte)'c');
        buf.put((byte)'d');

        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(Arrays.toString(bytes));
        buf.flip();
        buf.mark();
        if(buf.hasRemaining()) {
            System.out.println(buf.get());
            System.out.println(buf.get());
            System.out.println(buf.get());
            System.out.println(buf.get());
        }
        System.out.println(Arrays.toString(bytes));

        buf.reset();
        if(buf.hasRemaining()) {
            System.out.println(buf.get());
            System.out.println(buf.get());
            System.out.println(buf.get());
            System.out.println(buf.get());
        }
    }
}
