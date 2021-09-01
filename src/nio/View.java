package nio;

import java.nio.*;
import java.util.Arrays;

/**
 * @author bliu
 * @date 2021-03-16 10:19
 */
public class View {
    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocate(16).order(ByteOrder.BIG_ENDIAN);
        IntBuffer buf1 = buf.asIntBuffer();

//        CharBuffer charBuffer = buf.asCharBuffer();
//        buf.put(0, (byte)0);// position 不变
//        buf.put(1, (byte)'-');
//        buf.put(2, (byte)0);
//        buf.put(3, (byte)'i');
//        buf.put(4, (byte)0);

//       println(charBuffer);
//       println(buf);
        buf.putInt(5);
        buf.putInt(12);
//        buf1.put(200);
//        buf1.put(256);

        println(buf);
        println(buf1);

        System.out.println(Arrays.toString(buf.array()));
        System.out.println(buf1);
        System.out.println(buf1.get(0));
        System.out.println(buf1.get(1));
//        System.out.println(Arrays.toString(arr));

        buf.flip();
        System.out.println(buf.getInt());
        System.out.println(buf.getInt());
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
