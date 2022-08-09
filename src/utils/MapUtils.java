package utils;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    public static  <K,V> V getNoneNullVal(Map<K,V> map, K key, V defaultVal) {
        return map.getOrDefault(key, defaultVal) == null ? defaultVal : map.getOrDefault(key, defaultVal);
    }

    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();
        m.put("name", "张三");
        m.put(null, "lisi");
        m.put("age", null);

        String name = MapUtils.getNoneNullVal(m, "age", "100");
        String email = MapUtils.getNoneNullVal(m, "email", "3298934@qq.com");
        String nullKey = MapUtils.getNoneNullVal(m, null, "null key");
        String nExistsKey = MapUtils.getNoneNullVal(m, "not exists key", "not exists key");
        System.out.println(name);
        System.out.println(email);
        System.out.println(nullKey);
        System.out.println(nExistsKey);
    }
}
