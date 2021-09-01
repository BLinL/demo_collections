package nio;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.Arrays;

/**
 * @author bliu
 * @date 2021-03-16 10:55
 */
public class IntBufferTest {
    public static void main(String[] args) {
        IntBuffer buf = IntBuffer.allocate(4);
        buf.put(1);
        buf.put(2);
        buf.put(3);
        buf.put(4);

        int[] dst = new int[4];
        buf.flip();
//        buf.get(dst);
//        System.out.println(Arrays.toString(dst));
        System.out.println(buf.get());
        System.out.println(buf.get());
        System.out.println(buf.get());
        System.out.println(buf.get());
        println(buf);
    }

    // Print info about a buffer
    private static void println (Buffer buffer)
    {
        System.out.println ("pos=" + buffer.position( )
                + ", limit=" + buffer.limit( )
                + ", capacity=" + buffer.capacity( )
                + ": '" + buffer.toString( ) + "'");
    }
}
