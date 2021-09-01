package nio;

import java.nio.ByteOrder;

/**
 * @author bliu
 * @date 2021-03-16 10:12
 */
public class NativeOrder {
    public static void main(String[] args) {
        System.out.println(ByteOrder.nativeOrder());
    }
}
