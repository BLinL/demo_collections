package thread.executor;

import java.util.concurrent.Callable;

/**
 * @author bliu
 * @date 2021-03-25 9:31
 */
public class MyCallable<T>  implements Callable<T> {

    @Override
    public T call() throws Exception {
        Thread.sleep(5000);
        return (T)"call";
    }
}
