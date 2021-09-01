package thread;

public class ThreadLocalTest {

  static class Task implements Runnable,AutoCloseable{
    ThreadLocal<String> ctx = new ThreadLocal<>();
    @Override
    public void run() {
      try {
        ctx.set(Thread.currentThread().getName() + " hello wo");
//        try {
//          Thread.sleep(2000);
//        } catch (InterruptedException interruptedException) {
//          interruptedException.printStackTrace();
//        }
        fun1();
        fun2();
      }finally {
        ctx.remove();
      }
    }

    private void fun2() {
      System.out.println(Thread.currentThread().getName() + " " + ctx.get());
    }

    private void fun1() {
      System.out.println(Thread.currentThread().getName() + " " +ctx.get());
    }

    @Override
    public void close() throws Exception {
      ctx.remove();
    }
  }


  public static void main(String[] args) throws InterruptedException {
    Task myTask = new Task();
    Thread th1 = new Thread(myTask,"1");
    Thread th2 = new Thread(myTask,"2");

    th1.start();
    Thread.sleep(2000);
    th2.start();
  }

}
