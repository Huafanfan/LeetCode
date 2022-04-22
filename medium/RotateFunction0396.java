package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/4/22 09:34
 */
public class RotateFunction0396 {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        if (n == 1){
            return 0;
        }
        int numsSum=0;
        int last = 0;
        for (int i=0; i<n; i++){
            last += i * nums[i];
            numsSum += nums[i];
        }
        int res = last;
        for (int i=1; i<n; i++){
            int cur = last + numsSum - n * nums[n - i];
            res = Math.max(res, cur);
            last = cur;
        }
        return res;
    }
}
