package utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Utils {

  public static void main(String[] args) throws UnsupportedEncodingException {
    demo2();
    System.out.println(toBase64("hello"));
  }

  public static String toBase64(String str){
    return Base64.getEncoder().encodeToString(str.getBytes());
  }

  public static void demo2() throws UnsupportedEncodingException {
    String a = "鸟";
    byte[] utf8Bytes = a.getBytes("utf-8");
    for (byte b : utf8Bytes) {
      System.out.print(b);
      System.out.print("    ");
      System.out.println(Integer.toBinaryString(b));
    }
    System.out.println();
    byte[] gbkBytes = a.getBytes("gbk");
    for (byte b : gbkBytes) {
      System.out.print(b);
      System.out.print("    ");
      System.out.println(Integer.toBinaryString(b));
    }
  }
}
