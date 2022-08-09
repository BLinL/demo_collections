package utils;

import java.util.Map;

public class MapUtils {

    public <K,V> V getOrDefault(Map<K,V> map, K key, V defaultVal) {
        return map.getOrDefault(key, defaultVal);
    }
}
