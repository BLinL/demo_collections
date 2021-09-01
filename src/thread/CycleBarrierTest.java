package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 线程间相互等待 cyclicBarrier可复用
 * 类似跑步比赛 各位选手全部就位后 裁判才会打响发令枪
 */
public class CycleBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("5个线程就位");
            }
        });

        for (int i = 0; i < 5; i++) {
            Thread th = new Thread(new Task(cyclicBarrier));
            th.start();
        }

    }
}

class Task implements Runnable{

    private CyclicBarrier cyclicBarrier;

    public Task(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 已就位");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (BrokenBarrierException e) {
           //e.printStackTrace();
            System.out.println(cyclicBarrier.isBroken());
        }

        //任务
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}
