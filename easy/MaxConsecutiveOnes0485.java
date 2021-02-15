package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/15 11:25
 */
public class MaxConsecutiveOnes0485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 0;
            }
        }
        res = Math.max(res, count);
        return res;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int fast = 0, slow = 0, max = 0;
        while(slow < nums.length){
            if(nums[slow] != 1) {
                slow++;
            } else{
                fast = slow;
                while(fast < nums.length && nums[fast] == 1) {
                    fast++;
                }
                if(max < fast-slow) {
                    max = fast-slow;
                }
                slow = fast;
            }
        }
        return max;
    }
}
