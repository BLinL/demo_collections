package collection;

import java.util.concurrent.*;

public class FeatureTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        return System.currentTimeMillis() + "_" + Math.random() + "";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Callable<String> task = new FeatureTask();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Future<String> ret = pool.submit(task);
        Future<String> ret1 = pool.submit(task);
        String data = ret.get(500, TimeUnit.MILLISECONDS);
//        String data1 = ret1.get(500, TimeUnit.MILLISECONDS);

        System.out.println("ret1.isDone() = " + ret1.isDone());
        System.out.println(data);
//        System.out.println(data1);

        pool.shutdown();
    }
}
