package thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService service = Executors.newCachedThreadPool();
//        service.execute(new MyTask());
//
//        Thread.sleep(1);
//        service.shutdownNow();//shutdown不再接受新任务 shutdownNow 立即停止线程

        Runnable target;
        Thread th = new Thread(new MyTask());
        th.start();

        Thread.sleep(1);
        th.interrupt();

        System.out.println("interrupted  !");
    }

    static class MyTask implements Runnable{

        int i = 0;
//        @Override
//        public void run() {
//            try {
//                while(!Thread.currentThread().isInterrupted()) {
//                    System.out.println(++i);
//
//                    System.out.println("interrupted?"+Thread.currentThread().isInterrupted());
//                    System.out.println("isAlive?"+Thread.currentThread().isAlive());
//
//
//                    Thread.sleep(1000);
//
//                }
//
//            }catch (InterruptedException e){
//                //
//                System.out.println("thread is interrupted!");
//            }finally {
//                i = 0;
//            }
//
//        }

        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()) {
                System.out.println(++i);

                System.out.println("interrupted?"+Thread.currentThread().isInterrupted());
                System.out.println("isAlive?"+Thread.currentThread().isAlive());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    Thread.currentThread().interrupt();//重新设置中断状态
                }
            }
        }
    }
}
