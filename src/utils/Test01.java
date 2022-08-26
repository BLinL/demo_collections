package utils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

public class Test01 {

    public static void main(String[] args) {
        Map<String, BigDecimal> map = new HashMap<>();
        map.put("a", new BigDecimal("1.5"));
        map.put("b", new BigDecimal("2"));
        map.put("c", new BigDecimal("2.5"));

        BigDecimal result = map.values().stream().reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
        System.out.println(result);
        System.out.println("haha");
        System.out.println("hehe");
    }
}
