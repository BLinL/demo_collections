package nio.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author bliu
 * @date 2021-03-26 14:35
 */
public class RandomAccessFileTest {
    static final String fileName = "G:\\workspace_idea\\socketDomo\\src\\nio\\file\\FileReader.java";
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "r");
        FileChannel inChannel = randomAccessFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(2000);
        while(inChannel.read(buf) > 0) {
            buf.flip();
            Charset charset = Charset.forName("UTF-8");
            System.out.println(charset.newDecoder().decode(buf));

        }

//
    }
}
