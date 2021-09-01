import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile srcFile = new RandomAccessFile("G:\\tt.txt","rw");
        FileChannel inChannel = srcFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(100);

        int len;

        while((len = inChannel.read(buffer)) != -1){
            System.out.print(new String(buffer.array(),0,len,"utf-8"));
            buffer.clear();//
        }
//        System.out.println(len);
        inChannel.close();
    }
}
