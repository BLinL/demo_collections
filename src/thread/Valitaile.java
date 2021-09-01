package thread;

public class Valitaile {
  static boolean f = true;
  static int x;
  static int y;

  public static void main(String[] args) throws InterruptedException {

//    Thread th = new Thread(()->{
//      while(f) {
//        //System.out.println("th running");
//      }
//    });
//
//
//    th.start();
//
//    Thread.sleep(1000);
//    f = false;//


    new Thread(()->{
      y = 10;
      x = 20;
    },"t1").start();
    new Thread(()->{
      // x=20 对 t2 可见, 同时 y=10 也对 t2 可见
      System.out.println(x);
      System.out.println(y);
    },"t2").start();
  }
}
