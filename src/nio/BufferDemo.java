package nio;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * remaining 可以理解为可读数量 limit - position
 *
 * @author bliu
 * @date 2021-02-23 10:07
 */
public class BufferDemo {
    public static void main(String[] args) {
        //在堆内存分配空间
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        print(byteBuffer);

        //add element
        byteBuffer.put(new byte[]{1, 2, 3});
        System.out.print("after put : ");
        print(byteBuffer);

        //设置 获取 某个位置的值
        byteBuffer.position(5);
        byteBuffer.put((byte)5);
//        byteBuffer.position(5);
//        System.out.println("get"+ byteBuffer.get());
        System.out.println(Arrays.toString(byteBuffer.array()));
        /**
         *
         * p position
         * l limit
         * c capacity
         *  0  1  2  3  4  5  6  7  8  9  10
         * [1, 2, 3, 0, 0, 5, 0, 0, 0, 0  _]
         *                    p          l/c
         *                    |____________|
         *                         |
         *                    remaining
         */
        System.out.println(byteBuffer.position());
        byteBuffer.mark();
        System.out.print("after mark: ");
        print(byteBuffer);
        byteBuffer.position(9); //throws InvalidMarkException if index less than before
        System.out.print("after set position: ");
        print(byteBuffer);
        byteBuffer.reset();
        System.out.print("after reset: ");
        print(byteBuffer);

        byteBuffer.flip(); // transfer to read mod  limit = position ; position = 0
        System.out.print("after flip: ");
        print(byteBuffer);

        if (byteBuffer.hasArray()) {
            byte[] dist = byteBuffer.array();
            System.out.println("array : " + Arrays.toString(dist));

            //change array Buffer also changed
            dist[0] = 100;
            System.out.println("change array : " + Arrays.toString(dist));

        }

        //



        // how much element that can be read
        int waitToRead = byteBuffer.remaining();

        // 复制数据
        byte[] dist1 = new byte[waitToRead];
        for (int i = 0; i < waitToRead; i++) {
            // get() each time called position add 1
            dist1[i] = byteBuffer.get();
//            System.out.println("----------");
//            print(byteBuffer);
        }
        System.out.print("after read: ");
        print(byteBuffer);
        System.out.println("dist1 : " + Arrays.toString(dist1));
        //当需要重复读时很有用
        byteBuffer.rewind(); // position = 0; mark = -1
        System.out.print("after rewind: ");
        print(byteBuffer);

        ByteBuffer buf = ByteBuffer.wrap(new byte[]{12,14,13,15});
        //更高效的方式
        byte[] dist2 = new byte[3];

        while (buf.hasRemaining()) {
            int min = Math.min(buf.remaining(), dist2.length);
            buf.get(dist2, 0, min); //默认 dist2.length
            System.out.println("dist2: " + Arrays.toString(dist2));
//            handData(dist2, min);
        }

    }

    private static void print(ByteBuffer buffer) {
        System.out.printf("position: %d, limit: %d, capacity: %d , remaining: %d \n",
                buffer.position(), buffer.limit(), buffer.capacity(), buffer.remaining());
    }

}
