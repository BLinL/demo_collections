package utils;

import java.math.BigInteger;
import java.util.Deque;

public class StringUtils {
    static char[] chars = "0123456789ABCDEF".toCharArray();
    public static String str2HexStr(String str) {
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;// 4个字节
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0xff) >> 4;//高24位补0，低八位不变 取高28位
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;//取低4位
            sb.append(chars[bit]);
            // sb.append(' ');
        }
        return sb.toString().trim();
    }

    //c8b8c6c2
    public static void main(String[] args) {
//        String s="c2c6b8c8";
        //Float value = Float.intBitsToFloat(Integer.parseInt("c28d2807", 16));
//        System.out.println(value);
        BigInteger b = new BigInteger("c28d2807", 16);
        int l = 0xc28d2807;
        System.out.println("hex2Int---->"+b.intValue());
        System.out.println("int2Hex---->"+Integer.toHexString(l));
        System.out.println("hex2Long---->"+b.longValue());
        System.out.println("hex2Float---->"+Float.intBitsToFloat(l));
        System.out.println("hex2Float---->"+Float.intBitsToFloat(b.intValue()));
        System.out.println("hex2Double---->"+Double.longBitsToDouble(b.longValue()));

        //System.out.println(Integer.parseInt(3264030727,10));
    }
}
