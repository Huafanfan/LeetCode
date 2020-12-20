package lcof;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/20 13:31
 */
public class Lcof57 {
    /**
     * 24.89%
     * 58.37%
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = left + (right - left) / 2;
        while (left <= right){
            if (nums[mid]==target){
                break;
            }
            else if (nums[mid]<target){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
            mid = left + (right - left) / 2;
        }
        for (int i=right; i>=0; i--){
            for (int j=0; j<i; j++){
                if (nums[j] + nums[i] == target){
                    return new int[]{nums[j], nums[i]};
                }
            }
        }
        return null;
    }

    /**
     * 97.25%
     * 77.19%
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) {
                i++;
            } else if(s > target) {
                j--;
            } else {
                return new int[] { nums[i], nums[j] };
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,26,30,31,47,60};
        Lcof57 lcof57 = new Lcof57();
        System.out.println(Arrays.toString(lcof57.twoSum(nums, 40)));
    }
}
