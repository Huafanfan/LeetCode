package lcof;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/16 11:14
 */
public class Lcof21 {
    /**
     * 29.92%
     * 65.36%
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int oddIndex = 0;
        int evenIndex = nums.length-1;
        for (int i=0; i<nums.length && oddIndex < evenIndex;){
            if (nums[i]%2 == 1){
                int temp = nums[oddIndex];
                nums[oddIndex] = nums[i];
                nums[i] = temp;
                oddIndex++;
                i++;
            }
            else {
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[i];
                nums[i] = temp;
                evenIndex--;
            }
        }
        return nums;
    }

    /**
     * 99.30%
     * 39.66%
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while(i < j) {
            while(i < j && (nums[i] & 1) == 1) {
                i++;
            }
            while(i < j && (nums[j] & 1) == 0) {
                j--;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    /**
     * 99.30%
     * 70.43%
     * @param nums
     * @return
     */
    public int[] exchange3(int[] nums) {
        int low = 0, fast = 0, tmp;
        while(fast < nums.length) {
            if ((nums[fast] & 1) == 1){
                tmp = nums[fast];
                nums[fast] = nums[low];
                nums[low] = tmp;
                low++;
            }
            fast++;
        }
        return nums;
    }

    public static void main(String[] args) {
        Lcof21 lcof21 = new Lcof21();
        int[] nums = new int[]{2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};
        System.out.println(Arrays.toString(lcof21.exchange(nums)));
    }
}
