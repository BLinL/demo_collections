package nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author bliu
 * @date 2021-03-16 11:14
 */
public class Unsigned {

    public static short getUnsignedByte(byte bb) {
        return ((short) (bb & 0xff));
    }

    public static void putUnsignedByte(ByteBuffer bb, int value) {
        bb.put((byte) (value & 0xff));
    }

    public static short getUnsignedByte(ByteBuffer bb, int position) {
        return ((short) (bb.get(position) & (short) 0xff));
    }

    public static void putUnsignedByte(ByteBuffer bb, int position,
                                       int value) {
        bb.put(position, (byte) (value & 0xff));
    }

    // ---------------------------------------------------------------
    public static int getUnsignedShort(ByteBuffer bb) {
        return (bb.getShort() & 0xffff);
    }

    public static void putUnsignedShort(ByteBuffer bb, int value) {
        bb.putShort((short) (value & 0xffff));
    }

    public static int getUnsignedShort(ByteBuffer bb, int position) {
        return (bb.getShort(position) & 0xffff);
    }

    public static void putUnsignedShort(ByteBuffer bb, int position,
                                        int value) {
        bb.putShort(position, (short) (value & 0xffff));
    }

    // ---------------------------------------------------------------
    public static long getUnsignedInt(int bb) {
        return ((long) bb & 0xffffffffL);
    }

    public static void putUnsignedInt(ByteBuffer bb, long value) {
        bb.putInt((int) (value & 0xffffffffL));
    }

    public static long getUnsignedInt(ByteBuffer bb, int position) {
        return ((long) bb.getInt(position) & 0xffffffffL);
    }

    public static void putUnsignedInt(ByteBuffer bb, int position,
                                      long value) {
        bb.putInt(position, (int) (value & 0xffffffffL));
    }

    public static void main(String[] args) {
        System.out.println(getUnsignedByte((byte)-56));

    }
}
