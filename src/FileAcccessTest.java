import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileAcccessTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile srcFile = new RandomAccessFile("G:\\tonglei.zip","rw");
        RandomAccessFile dstFile = new RandomAccessFile("G:\\copy_tonglei.zip","rw");
        FileChannel channel = srcFile.getChannel();
        FileChannel channel1 = dstFile.getChannel();

        long begin = System.currentTimeMillis();
        System.out.println(begin);

        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY,0,srcFile.length());
        channel1.write(mappedByteBuffer);

        channel.close();
        channel1.close();

        System.out.println("read time:"+ (System.currentTimeMillis() - begin) + "ms");

    }
}
