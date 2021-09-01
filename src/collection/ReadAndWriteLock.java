package collection;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteLock {
    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock rLock = rwLock.readLock();
    ReentrantReadWriteLock.WriteLock wLock = rwLock.writeLock();

    int[] count = new int[100];


    public void inc(int index){
        wLock.lock();
        try {
            count[index] += 1;
        }finally {
            wLock.unlock();
        }

    }

    public int get(int index){
        rLock.lock();
        try {
            return count[index];
        }finally {
            rLock.unlock();
        }
    }

    //不加读锁可能读到中间状态， 此示例中不能体现
    public int[] get(){
        rLock.lock();
        try {
            return Arrays.copyOf(count, count.length);
        }finally {
            rLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadAndWriteLock aa = new ReadAndWriteLock();

        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            final int index = i;
            pool.execute(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                aa.inc(index);
            });
        }



        Thread th2 = new Thread(()->{
            for(;;){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(
                        Arrays.toString(aa.get())
                );
            }

        });

        th2.start();

    }
}
