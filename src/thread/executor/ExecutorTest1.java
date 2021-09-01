package thread.executor;

import java.util.concurrent.*;

/**
 *  RejectedExecutionException由FutureTask 负责抛出，与子线程是否跑抛异常无关
 *  execute 线程内部的异常如果不捕获, 一定会抛出异常
 *  submit 线程内部的异常如果不捕获, FutureTask会捕获  调用get()会抛出
 */
public class ExecutorTest1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ThreadPoolExecutor
        ExecutorService service = new ThreadPoolExecutor(3,
                5,
                0,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10));
//        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
        MyTask task = new MyTask();
        try {
            for (int i = 0; i < 20; i++) {
                try {
                    service.submit(task);//NEW
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }finally {
            service.shutdown();
        }

//        Future<String> f1 = service.schedule(task,2000,TimeUnit.MILLISECONDS);
//        Future<String> f2 = service.schedule(task,3000,TimeUnit.MILLISECONDS);

//
//        try {
//            System.out.println(f.get());
//        }catch (Exception e) {
//            System.out.println("---------");
//            e.printStackTrace();
//        }
//        System.out.println(f1.get());
//        System.out.println(f2.get());
    }
}

class MyTask implements Callable<String>{
    ThreadLocal<String> local = new ThreadLocal();//ThreadLocal对象的set()方法设置的值只对当前线程可见
    @Override
    public String call() {
        System.out.println(Thread.currentThread().getName() + "run");
        local.set(""+Thread.currentThread().getId());

        try {
            getThreadId();
        }catch (Exception e) {
            System.out.println("子线程捕获到了异常");
        }

        return "" + Thread.currentThread().getId();
    }

    private void getThreadId() throws NullPointerException{
        System.out.println("local variable thread Id " +  local.get());
//        throw new NullPointerException();
    }
}
