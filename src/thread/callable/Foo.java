package thread.callable;

import java.util.concurrent.*;

//task
public class Foo implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("thread is run");

            int s = 0;
            for (int i = 0; i < 10000; i++) {
                s++;
            }

            Thread.sleep(3000);
            return "ok" + s;

    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        Future<String> result = cachedPool.submit(new Foo());
        cachedPool.shutdown();

        Thread.sleep(1000);
//        boolean canceled = result.cancel(false);
//        System.out.println("is cancled?" + canceled);
        try {
            System.out.println(result.get());//阻塞
        } catch (ExecutionException e) {
//            e.printStackTrace();

        }

//        Foo callable = new Foo();
//        FutureTask<String> futureTask = new FutureTask<>(callable);
//        cachedPool.submit(futureTask);
//        Thread.sleep(1000);
//        futureTask.cancel(true);
//        cachedPool.shutdown();
//        System.out.println(futureTask.get());
    }
}
