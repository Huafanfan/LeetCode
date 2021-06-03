package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/6/3 10:44
 */
public class ContiguousArray0525 {
    public int findMaxLength(int[] nums) {
        int length = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i=0; i<length; i++){
            if (nums[i] == 1){
                sum++;
            }
            else {
                sum--;
            }
            if (map.containsKey(sum)){
                max = Math.max(max, i - map.get(sum));
            }
            else{
                map.put(sum, i);
            }

        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
