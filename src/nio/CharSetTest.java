package nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class CharSetTest {
    public static void main(String[] args) {

        Charset charset = Charset.forName("UTF-8");

        System.out.println(charset.displayName());
        System.out.println(charset.canEncode());

        String st = "this is a charset example 示例";
        ByteBuffer byteBuffer = ByteBuffer.wrap(st.getBytes());
        CharBuffer charbuffer = charset.decode(byteBuffer);

        System.out.println(charbuffer.array());

        ByteBuffer newBytebuffer = charset.encode(charbuffer);
        while(newBytebuffer.hasRemaining()){
            System.out.print((char)newBytebuffer.get());
        }
        newBytebuffer.clear();
    }
}
