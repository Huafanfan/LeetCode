package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/2 15:01
 */
public class TargetSum0494 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        TargetSum0494 targetSum0494 = new TargetSum0494();
        System.out.println(targetSum0494.findtargetsumwaysdp(nums,3));
    }
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }
    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) {
                count++;
            }
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }

    public int findtargetsumwaysdp(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    //dp[i][sum + 1000] = dp[i - 1][sum - nums[i] + 1000] + dp[i - 1][sum + nums[i] + 1000];
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

    public int findtargetsumwaysdp2(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(S) > Math.abs(sum)) {
            return 0;
        }
        int len = nums.length;
        // - 0 +
        int t = 2 * sum + 1;
        int[][] dp = new int[len][t];
        //将sum为中心，负值移动到正值
        if (nums[0] == 0){
            dp[0][sum] = 2;
        }
        else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }
        for (int i=1; i<len; i++){
            for (int j=0; j<t; j++){
                int l = Math.max(j - nums[i], 0);
                int r = (j+nums[i]<t)?(j+nums[i]):0;
                dp[i][j] = dp[i-1][l] + dp[i-1][r];
            }
        }
        return dp[len-1][sum+S];
    }
}
