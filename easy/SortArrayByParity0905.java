package easy;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/4/28 10:50
 */
public class SortArrayByParity0905 {
    public int[] sortArrayByParity(int[] nums) {
        int odd = nums.length - 1;
        int even = 0;
        int index = 0;
        while (even < odd){
            if (nums[index] % 2 == 0){
                even ++;
                index++;
            }
            else {
                int temp = nums[odd];
                nums[odd] = nums[index];
                nums[index] = temp;
                odd--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParity0905 sortArrayByParity0905 = new SortArrayByParity0905();
        int[] nums = new int[]{3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity0905.sortArrayByParity(nums)));
    }
}
