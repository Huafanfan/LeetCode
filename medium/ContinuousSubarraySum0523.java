package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/6/2 11:25
 */
public class ContinuousSubarraySum0523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int length = nums.length;
        if (length < 2){
            return false;
        }
        int[] sum = new int[length + 1];
        sum[0] = nums[0];
        for (int i=0; i<length; i++){
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i=0; i<length; i++){
            for (int j=i+1; j<length; j++){
                if ((sum[j+1] - sum[i]) % k == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
