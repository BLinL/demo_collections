package thread.executor;

import java.util.concurrent.*;

/**
 * @author bliu
 * @date 2021-03-25 9:31
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        MyCallable<String> mytask = new MyCallable<>();

        String sd = null;
        Future<String> result = pool.submit(mytask);
        try {
//            result.cancel(true);
            System.out.println(result.isDone());

            System.out.println(result.get(5000, TimeUnit.MILLISECONDS));
        }catch (Exception e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }
}
