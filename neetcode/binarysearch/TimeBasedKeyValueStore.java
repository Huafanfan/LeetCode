package neetcode.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/14 16:22
 */
public class TimeBasedKeyValueStore {
    public static class Value {
        String v;
        int time;

        public Value(String v, int time) {
            this.v = v;
            this.time = time;
        }

        public String getV() {
            return v;
        }

        public int getTime() {
            return time;
        }
    }

    Map<String, List<Value>> map;
    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Value> list = map.getOrDefault(key, new ArrayList<>());
        Value v = new Value(value, timestamp);
        list.add(v);
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        List<Value> list = map.getOrDefault(key, null);
        if (list == null){
            return "";
        }
        int l = 0, r = list.size()-1;
        while (l < r){
            int m = l + (r - l + 1)/2;
            if (list.get(m).time == timestamp){
                return list.get(m).getV();
            } else if (list.get(m).time > timestamp){
                r = m - 1;
            } else {
                l = m;
            }
        }
        if (list.get(l).getTime() > timestamp){
            return "";
        }
        return list.get(l).getV();
    }
}
