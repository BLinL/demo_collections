package synchronizers;

import java.util.concurrent.Semaphore;

/**
 * @author bliu
 * @date 2021-03-09 14:57
 */
public class UsingSemphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2, true);

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();//请求许可
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " get in");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();//释放许可
                }
            }).start();
        }

        new Thread(()->{
            for(;;) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("======状态：" + semaphore.hasQueuedThreads());
            }
        }).start();
    }
}
