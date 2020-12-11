package lcof;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/11 14:13
 */
public class Lcof03 {
    /**
     * 100.00%
     * 90.22%
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        for (int i=0; i<nums.length;){
            if (nums[i] == i){
                i++;
            }
            else {
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                else {
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return -1;
    }

    /**
     * 49.72%
     * 14.79%
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    ///**
    // *
    // * @param nums
    // * @return
    // */
    //public int findRepeatNumber3(int[] nums) {
    //    int length = nums.length;
    //    if (length<1){
    //        return -1;
    //    }
    //    int start = 0, end = length-1;
    //    while (end >= start){
    //        int middle = ((end - start)>>1)+start;
    //        int count = countRange(nums, length, start, middle);
    //        if (end == start){
    //            if (count>1){
    //                return start;
    //            }
    //            else {
    //                break;
    //            }
    //        }
    //        if (count > (middle-start+1)){
    //            end = middle;
    //        }
    //        else {
    //            start = middle+1;
    //        }
    //    }
    //    return -1;
    //}
    //
    //public int countRange(int[] nums, int length, int start, int end){
    //    if (length==0){
    //        return 0;
    //    }
    //    int count = 0;
    //    for (int i=0; i<length; i++){
    //        if (nums[i] >= start && nums[i] <= end){
    //            count++;
    //        }
    //    }
    //    return count;
    //}

    public static void main(String[] args) {
        Lcof03 lcof03 = new Lcof03();
        int[] nums = new int[]{0, 1, 2, 0, 4, 5, 6, 7, 8, 9};
        System.out.println(lcof03.findRepeatNumber2(nums));
    }
}
