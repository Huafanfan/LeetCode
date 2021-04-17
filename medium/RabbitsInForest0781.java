package medium;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest0781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int y = entry.getKey(), x = entry.getValue();
            // x / (y + 1) 向上取整为 (x + y) / (y + 1)
            ans += (x + y) / (y + 1) * (y + 1);
        }
        return ans;
    }
}
