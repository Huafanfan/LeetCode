package easy;

import java.util.Arrays;

/**
 * @author yifan.zhangyf
 * @date 2022/9/12 4:14 PM
 */
public class SpecialArrayWithXElementsGreaterThanOrEqualX1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int num = 1;
        for (int i=nums.length-2; i>=-1; i--){
            if (nums[i + 1] >= num && (i == -1 || nums[i] < num)){
                return num;
            }
            num++;
        }
        return -1;
    }
}
