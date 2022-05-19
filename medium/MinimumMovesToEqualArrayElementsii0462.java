package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/19 11:12
 */
public class MinimumMovesToEqualArrayElementsii0462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = nums[n / 2];
        int res = 0;
        for (int num : nums){
            res += Math.abs(num - mid);
        }
        return res;
    }
}
