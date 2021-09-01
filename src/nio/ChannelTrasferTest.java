package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelTrasferTest {

    public static void main(String[] args) throws IOException {

        RandomAccessFile src = new RandomAccessFile("g://Win10_1903_V1_Chinese(Simplified)_x64.iso","r");
        src.seek(1000);
        FileChannel fromChannel = src.getChannel();
        System.out.println(fromChannel.position());
        fromChannel.position(500);
        System.out.println(src.getFilePointer());
//        RandomAccessFile dst = new RandomAccessFile("g://copy_win10.iso","rw");
//        FileChannel toChannel = dst.getChannel();
//
//        fromChannel.transferTo(0,fromChannel.size(),toChannel);
        System.out.println("done");
    }
}
