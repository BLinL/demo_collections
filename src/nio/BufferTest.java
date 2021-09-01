package nio;

import java.nio.ByteBuffer;

public class BufferTest {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(100);

        System.out.println("初始状态");
        bufferStatue(buffer);

        buffer.put((byte)1);
        buffer.put((byte)2);
        buffer.put((byte)3);

        System.out.println("写入三个数据");
        bufferStatue(buffer);

        buffer.flip();//
        System.out.println("flip buffer ");
        bufferStatue(buffer);

//        byte[] dst1 = new byte[100];
//        int i = 0;
//        while(buffer.remaining() > 0){
//            byte byt = buffer.get();dst1[i] = byt;
//            i++;
//        }
//        buffer.position(1);
        //buffer.get(dst1,0,buffer.limit());

//        for (int j = 0; j < dst1.length; j++) {
//            System.out.println(dst1[j]);
//        }
//
//        buffer.clear();
//        System.out.println("clear buffer ");
//        bufferStatue(buffer);
//
//        buffer.rewind();
//        byte[] dst = new byte[100];
//        buffer.get(dst,0,buffer.limit());
//
//        System.out.println("---------------");
//        for (int j = 0; j < dst.length; j++) {
//            System.out.println(dst[j]);
//        }

        byte bb = buffer.get();
        System.out.println("get:"+bb);

        buffer.compact();
        System.out.println("compact:");
        bufferStatue(buffer);

    }
    static void bufferStatue(ByteBuffer buffer){
        System.out.println("position:"+buffer.position());
        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());
    }
}
