package medium;

public class LongestIncreasingSubsequence0300 {
    public int lengthOfLIS(int[] nums) {
        int length = 1, n = nums.length;
        if (n == 0){
            return 0;
        }
        //长度为 i 的最长上升子序列的末尾元素的最小值
        int[] queue = new int[n + 1];
        queue[length] = nums[0];
        for (int i=1; i<nums.length; i++){
            if (nums[i] > queue[length]){
                queue[++length] = nums[i];
            }
            else {
                int left = 0;
                int right = length;
                while (left < right){
                    int mid = (right - left + 1) / 2 + left;
                    if (queue[mid] < nums[i]){
                        left = mid;
                    }
                    else {
                        right = mid - 1;
                    }
                }
                queue[left+1] = nums[i];
            }
        }
        return length;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence0300 longestIncreasingSubsequence = new LongestIncreasingSubsequence0300();
        //int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int[] nums = new int[]{8,9,10,5,3,7,101,18};
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums));
    }
}
