package easy;

import java.util.HashMap;
import java.util.Map;

public class RangeSumQueryImmutable0303 {
    int[] map;
    public RangeSumQueryImmutable0303(int[] nums) {
        int len = nums.length;
        map = new int[len];
        int sum = 0;
        for (int i=0; i<len; i++){
            sum += nums[i];
            map[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return map[j] - (i > 0 ? map[i-1] : 0);
    }
}
