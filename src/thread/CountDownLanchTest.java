package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 假设有三个同学 老师必须等到三个同学都完成作业才开始检查
 */
public class CountDownLanchTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        final CountDownLatch latch = new CountDownLatch(3);//Thread count
        Student s1 = new Student(latch);
        Student s2 = new Student(latch);
        Student s3 = new Student(latch);

        Thread teacher = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

                System.out.println("老师检查");
            }
        });
        executorService.execute(teacher);
        executorService.execute(s1);
        executorService.execute(s2);
        executorService.execute(s3);


        executorService.shutdown();
    }
}
class Student implements Runnable {
    private CountDownLatch latch;

    public Student(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " begin do home work");

        try {
            //模拟做作业时间
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "已完成");
        //完成作业 执行
        latch.countDown();
    }
}
