package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Producer {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition notEmpty = lock.newCondition();
        Condition notFull = lock.newCondition();
        List<String> list = new ArrayList<>();

        Thread t1 = new Thread(() -> {
            boolean  flag = true;

            try {
                while(flag) {
                    lock.lock();

                    while(list.size() == 1) {
                        try {
                            notFull.await(); // require lock
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            flag = false;
                        }
                    }

                    list.add("1");
                    System.out.println(Thread.currentThread().getName() + "-producer--");
                    notEmpty.signalAll();
                }
            }finally {
                lock.unlock();
            }
        });

        Thread t1_1 = new Thread(() -> {
            boolean  flag = true;

            try {
                while(flag) {
                    lock.lock();

                    while(list.size() == 1) {
                        try {
                            notFull.await(); // require lock
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            flag = false;
                        }
                    }

                    Thread.sleep(1000);
                    list.add("2");
                    System.out.println(Thread.currentThread().getName() + "-producer");
                    notEmpty.signalAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            boolean  flag = true;

            try {
                while(flag) {
                    lock.lock();

                    while(list.size() == 0) {
                        try {
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            flag = false;
                        }
                    }

                    String data = list.remove(0);
                    System.out.println("consumer--"+ data);
                    notFull.signalAll();
                }
            }finally {
                lock.unlock();
            }
        });

        t1.start();
        t1_1.start();
        t2.start();


    }

}
