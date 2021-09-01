package synchronizers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UsingCondition {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    int[] arr = new int[100];
    int count, putIndex, takeIndex;


    public void put(int x) {
        lock.lock();
        while (count == arr.length) {
            try {
                notFull.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        arr[putIndex] = x;
        putIndex++;
        if (putIndex == arr.length) {
            putIndex = 0;
        }
        count++;
        notEmpty.signal();
        System.out.println(Thread.currentThread().getName() + "put data " + x);
        lock.unlock();
    }

    public int take() {
        lock.lock();
        int x = -1;
        try {
            while (count == 0) {

                notEmpty.await();
            }

            x = arr[takeIndex];
            if (++takeIndex == arr.length) {
                takeIndex = 0;
            }

            count--;
            notFull.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return x;
    }

    public static void main(String[] args) {
        UsingCondition uCondit = new UsingCondition();
        ExecutorService service = Executors.newCachedThreadPool();


        Future<?> f = service.submit(() -> {
            for (int i = 0; i < 10; i++) {
                uCondit.put(i);
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        service.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + "take data:" + uCondit.take());
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        service.shutdown();
    }
}
