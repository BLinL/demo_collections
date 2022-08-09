package utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    public static  <K,V> V getNoneNullVal(Map<K,V> map, K key, V defaultVal) {
        return map.getOrDefault(key, defaultVal) == null ? defaultVal : map.getOrDefault(key, defaultVal);
    }

    public static <K,V> Map<K, V> merge(Map<K, V> map1, Map<K, V> map2) {
        if (map1 == null && map2 == null) {
            return Collections.EMPTY_MAP;
        }

        Map<K, V> merged = new HashMap<>();

        if (map1 != null && map2 == null) {
            merged.putAll(map1);
        }

        if (map1 == null && map2 != null) {
            merged.putAll(map2);
        }
        if (map1 != null && map2 != null) {
            merged.putAll(map1);
            merged.putAll(map2);
        }
        return merged;
    }

    public static void main(String[] args) {
//        Map<String, String> m = new HashMap<>();
//        m.put("name", "张三");
//        m.put(null, "lisi");
//        m.put("age", null);
//
//        String name = MapUtils.getNoneNullVal(m, "age", "100");
//        String email = MapUtils.getNoneNullVal(m, "email", "3298934@qq.com");
//        String nullKey = MapUtils.getNoneNullVal(m, null, "null key");
//        String nExistsKey = MapUtils.getNoneNullVal(m, "not exists key", "not exists key");
//        System.out.println(name);
//        System.out.println(email);
//        System.out.println(nullKey);
//        System.out.println(nExistsKey);

        Map<Object, Object> map = new HashMap<>();
        map.put("aa", 1);
        map.put("bb", "haha");
        Map<Object, Object> map2 = new HashMap<>();
        map.put("aa", 2);
        map.put("cc", 2);

        Map<Object, Object> result = MapUtils.merge(map, map2);
        result.forEach((k,v) -> {
            System.out.println("k:" + k + ", v:" + v);
        });
    }
}
