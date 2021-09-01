package thread;

import javax.management.relation.RoleUnresolved;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) throws InterruptedException {
        BlockContext blockContext = new BlockContext();
        Blocked blocked = new Blocked(blockContext);
        for (int i = 0; i < 2; i++) {
            Thread th = new Thread(blocked);
            th.start();
            th.join();
        }
    }
}
class Blocked implements Runnable{
    BlockContext blockContext = null;

    public Blocked(BlockContext blockContext) {
        this.blockContext = blockContext;
    }

    @Override
    public void run() {
        System.out.println("waiting for f");
        blockContext.f();
    }
}
class BlockContext{
    private Lock lock = new ReentrantLock();

    public BlockContext() {
        //lock.lock();
    }

    public void f(){
        try {
            lock.lockInterruptibly();
            System.out.println("enter lock");
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
