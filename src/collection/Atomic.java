package collection;

import java.util.concurrent.atomic.AtomicStampedReference;

public class Atomic {
    public static void main(String[] args) {
        int i = 1;
        int j = 2;

        AtomicStampedReference stampedReference = new AtomicStampedReference(i, 1);
        stampedReference.compareAndSet(i, j, stampedReference.getStamp(), stampedReference.getStamp() +1);
        System.out.println("stampedReference.getReference() = " + stampedReference.getReference());

        //update stamp
        boolean b = stampedReference.attemptStamp(j, stampedReference.getStamp() + 1);
        System.out.println("b = " + b);
        System.out.println("stampedReference.getStamp() = " + stampedReference.getStamp());


    }
}
