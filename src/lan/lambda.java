package lan;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class lambda {
    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("java", "c", "C++");

//        Collections.sort(l1,
//                (s1, s2)-> Integer.compare(s1.length(), s2.length()));
        l1.sort(Comparator.comparingInt(String::length));
        System.out.println(l1);
    }
}
