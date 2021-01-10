package hard.array;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/1/10 11:12
 *
 * 题目 #
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 *
 * Input: [1,2,0]
 * Output: 3
 *
 * Example 2:
 *
 *
 * Input: [3,4,-1,1]
 * Output: 2
 *
 * Example 3:
 *
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 */
public class FirstMissingPositive0041 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //判断是否有1
        boolean isHave1 = false;
        for (int num : nums){
            if (num == 1){
                isHave1 = true;
                break;
            }
        }
        if (!isHave1){
            return 1;
        }

        for (int i=0; i<n; i++){
            if (nums[i]<1 || nums[i] > n){
                nums[i] = 1;
            }
        }

        for (int i=0; i<n; i++){
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);
        }

        for (int i=0; i<n; i++){
            if (nums[i]>0){
                return i + 1;
            }
        }
        return n + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
