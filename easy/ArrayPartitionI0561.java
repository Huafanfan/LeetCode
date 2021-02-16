package easy;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/16 10:07
 */
public class ArrayPartitionI0561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int len = nums.length;
        for (int i = len - 2; i>=0 ; i -= 2){
            res += nums[i];
        }
        return res;
    }
}
