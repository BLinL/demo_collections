package thread.executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author bliu
 * @date 2021-03-22 13:28
 */
public class NetworkExecutor implements Runnable {
    private ServerSocket socket;
    private ExecutorService pool;

    public NetworkExecutor(int port, int poolSize) throws IOException {
        this.socket = new ServerSocket(port);
        this.pool = Executors.newFixedThreadPool(poolSize);
    }


    @Override
    public void run() {
        try {
            for (; ; ) {
                Socket sc = socket.accept();
                pool.execute(new Handler(sc));
            }
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws IOException {
        NetworkExecutor myPool = new NetworkExecutor(13000, 10);
        new Thread(myPool).start();

        myPool.shutdownAndAwaitTermination();
        System.out.println("main end");
    }

    private void shutdownAndAwaitTermination() {
        System.out.println("---");
        pool.shutdown(); // 不再接受新任务
        try {
            System.out.println("is termined:" + pool.isTerminated());

            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                System.out.println("111");

                if (!pool.awaitTermination(10, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}

class Handler implements Runnable {
    private final Socket socket;

    Handler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // read and service request on socket
    }
}