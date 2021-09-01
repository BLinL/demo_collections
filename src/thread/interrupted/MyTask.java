package thread.interrupted;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public final class MyTask implements Runnable{

//    private final Object obj = new Object();
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        String thread = Thread.currentThread().getName();

//        try {
//            Thread.sleep(1000);
//            System.out.println(thread + " end");
//        } catch (InterruptedException interruptedException) {
//            interruptedException.printStackTrace();
//
//
//        }

//        synchronized (obj) {
//            if(!Thread.currentThread().isInterrupted()) {
//                System.out.println(thread + " get lock");
//                return;
//            }
        try {
            lock.lockInterruptibly();
            System.out.println("enter lock");
        } catch (InterruptedException e) {
            lock.lock();
            e.printStackTrace();
            //reset interrupted state
//            Thread.currentThread().interrupt();
//            System.out.println(Thread.currentThread().isInterrupted());
        }finally {
            lock.unlock();
        }

//            try {
//                TimeUnit.SECONDS.sleep(5);
//                test(thread);
//            } catch (InterruptedException e) {
//                System.out.println("cache exception");
////                System.out.println("==thread interrupted "+Thread.currentThread().interrupted());
////                e.printStackTrace();
////                Thread.interrupted();
//            }
//        }
    }

    private void test(String threadName) {
        System.out.println(threadName + " get lock");
    }
}
