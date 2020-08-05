package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/5 15:00
 */
public class RemoveDuplicatesFromSortedArrayii0080 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length<=1){
            return nums.length;
        }
        int count = 1;
        int index = 1;
        for (int i=1; i<nums.length; i++){
            if (nums[i]!=nums[i-1]){
                count=1;
                nums[index++] = nums[i];
            }else if (nums[i]==nums[i-1]&&count<2){
                count++;
                nums[index++] = nums[i];
            }
        }
        return index;
    }
    public int removeDuplicatesNB(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
