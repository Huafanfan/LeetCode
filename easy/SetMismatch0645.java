package easy;

import java.util.Arrays;

public class SetMismatch0645 {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length];
        int dup = 0;
        for (int i=0; i<nums.length; i++){
            if (count[nums[i] - 1] == 0){
                count[nums[i] - 1] = nums[i];
            }
            else {
                dup = nums[i];
            }
        }
        for (int i=0; i<nums.length; i++){
            if (count[i] == 0){
                return new int[]{dup, i + 1};
            }
        }
        return null;
    }
}
