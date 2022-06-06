package hard;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/6 10:21
 */
public class MyCalendarIii0732 {

    private TreeMap<Integer, Integer> cnt;

    public MyCalendarIii0732() {
        cnt = new TreeMap<Integer, Integer>();
    }

    public int book(int start, int end) {
        int ans = 0;
        int maxBook = 0;
        cnt.put(start, cnt.getOrDefault(start, 0) + 1);
        cnt.put(end, cnt.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int freq = entry.getValue();
            maxBook += freq;
            ans = Math.max(maxBook, ans);
        }
        return ans;
    }
}
