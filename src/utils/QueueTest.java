package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
//        Queue<Integer> q = new ArrayDeque<>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.offer(4);
//        q.offer(5);
//        q.offer(6);
//        System.out.println(q);
//        System.out.println(q.remove());//取出并删除返回header没有抛出异常
//        System.out.println(q.poll());//取出并删除返回header没有返回null
//        System.out.println(q.element());//取出返回header没有抛出异常
//        System.out.println(q.peek());//取出返回header没有返回null
//        System.out.println(q);

        Class<?> clazz = Class.forName("PSD");
        Method psd = clazz.getMethod("PSD");
        Object rst = psd.invoke(clazz.newInstance(), Arrays.asList(1, 2, 3), 100, 10D);
        System.out.println(rst.getClass());
    }
}
