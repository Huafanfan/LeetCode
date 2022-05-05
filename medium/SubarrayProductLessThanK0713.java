package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/5 11:50
 */
public class SubarrayProductLessThanK0713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int prod = 1;
        int i = 0;
        for (int j=0; j<nums.length; j++){
            prod *= nums[j];
            while (i <= j && prod >= k){
                prod /= nums[i];
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}
