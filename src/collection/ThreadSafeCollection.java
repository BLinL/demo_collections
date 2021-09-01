package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeCollection {
    public static void main(String[] args) throws InterruptedException {

//        List<String> list = new CopyOnWriteArrayList<>();
        List<String> list = new ArrayList<>();
        Collections.synchronizedCollection(list);

        Thread th1 = new Thread(()->{

            for (int i = 0; i < 100; i++) {
                list.add("" + i);
            }
        });

        Thread th2 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                list.add("th-" + i);
            }
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println(list.size());
    }
}
