package synchronizers;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author bliu
 * @date 2021-03-09 14:13
 */
public class UsingBarriers {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CyclicBarrier barrier = new CyclicBarrier(10, () -> {
            System.out.println("well done");
        });

        Runnable task = ()->{
            try {
                // simulating a task that can take at most 1sec to run
                System.out.println("Doing task for " + Thread.currentThread().getName());
                Thread.sleep(new Random().nextInt(10) * 100);
                System.out.println("Done for " + Thread.currentThread().getName());
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 10; i++) {
            executor.execute(task);
        }

        executor.shutdown();
    }
}
