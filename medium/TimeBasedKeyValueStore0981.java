package medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/10 13:59
 */
public class TimeBasedKeyValueStore0981 {
    /** Initialize your data structure here. */
    HashMap<String, TreeMap<Integer,String>> map;
    public TimeBasedKeyValueStore0981() {
        map = new HashMap<>();

    }

    public void set(String key, String value, int timestamp) {
        //TreeMap<Integer, String> tmp = map.getOrDefault(key, new TreeMap<>());
        //tmp.put(timestamp, value);
        //map.put(key, tmp);
        map.computeIfAbsent(key, k->new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)){
            return "";
        }
        Integer time = map.get(key).floorKey(timestamp);
        if (time == null){
            return "";
        }
        else {
            return map.get(key).get(time);
        }
    }
}
