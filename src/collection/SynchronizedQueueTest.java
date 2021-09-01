package collection;

import java.awt.image.PackedColorModel;
import java.util.concurrent.SynchronousQueue;

/**
 * @author bliu
 * @date 2020-12-29 9:39
 */
public class SynchronizedQueueTest {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        Producer p = new Producer(resource);
        Consumer c = new Consumer(resource);
        Thread t = new Thread(p);
        Thread t1 = new Thread(c);
//        Thread t2 = new Thread(c);

        t.start();
        t1.start();
//        t2.start();

//        t.join();
//        t1.join();
//        t2.join();
    }

    static class Producer implements Runnable{
        private Resource resource;

        public Producer(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            while(!Thread.interrupted()) {
                try {
                    resource.put();
                    Thread.sleep(3000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable{
        private Resource resource;
        public Consumer(Resource resource) {
            this.resource = resource;
        }
        @Override
        public void run() {
            while(!Thread.interrupted()){
                try {
                    Thread.sleep(8000);
                    resource.take();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }
}
