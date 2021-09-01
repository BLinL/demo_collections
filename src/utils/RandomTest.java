package utils;

import java.util.Random;

public class RandomTest {
  private static final Random random = new Random();
  public static void main(String[] args) {
//    Random random = new Random();
    for (int i = 0; i < 100; i++) {
      //System.out.println(random.nextInt(5));// out 0 - 4
      System.out.println(randomDoubleRange(5, 10));
    }

  }

  /**
   * @param begin is begin of random num
   * @param end is end of random num
   * @return random number
   */
  public static int randomRange(int begin,int end){
    return random.nextInt(end - begin + 1) + begin;
  }

  /**
   * @param begin is begin of random num
   * @param end is end of random num
   * @return random number
   */
  public static double randomDoubleRange(double begin,double end){
    return random.nextDouble() * (end - begin) + begin;
  }
}
