package collection;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.concurrent.SynchronousQueue;

/**
 * @author bliu
 * @date 2020-12-29 9:40
 */
public class Resource {
    private SynchronousQueue<String> sq = new SynchronousQueue<>();

    public Resource(){
    }

    public void put() throws InterruptedException {
        sq.put("哇哈哈");
        System.out.println("["+System.currentTimeMillis()+"]"+Thread.currentThread().getName()+"生产哇哈哈");
    }

    public void take() throws InterruptedException {
        String s = sq.take();
        System.out.println("["+System.currentTimeMillis()+"]"+Thread.currentThread().getName() + "消费" + s);
    }
}
