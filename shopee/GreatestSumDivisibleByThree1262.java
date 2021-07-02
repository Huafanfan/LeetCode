package shopee;

public class GreatestSumDivisibleByThree1262 {
    public int maxSumDivThree(int[] nums) {
        int N = nums.length;
        int[] remainder = new int[3];
        for(int i = 0; i < N; i++){
            int a,b,c;
            a = remainder[0] + nums[i];
            b = remainder[1] + nums[i];
            c = remainder[2] + nums[i];
            remainder[a%3] = Math.max(remainder[a%3], a);
            remainder[b%3] = Math.max(remainder[b%3], b);
            remainder[c%3] = Math.max(remainder[c%3], c);
        }
        return remainder[0];
    }

    public int maxSumDivThree2(int[] nums) {
        int N = nums.length;
        //表示到i为止余数为j的最大和
        int[][] dp = new int[N + 1][3];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++){
            int x = nums[i - 1] % 3;
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][(3 - x) % 3] + nums[i-1]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][(4 - x) % 3] + nums[i-1]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][(5 - x) % 3] + nums[i-1]);
//            if (nums[i - 1] % 3 == 0){
//                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][0] + nums[i-1]);
//                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][1] + nums[i-1]);
//                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][2] + nums[i-1]);
//            }
//            else if (nums[i - 1] % 3 == 1){
//                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] + nums[i-1]);
//                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + nums[i-1]);
//                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + nums[i-1]);
//            }
//            else {
//                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + nums[i-1]);
//                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][2] + nums[i-1]);
//                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][0] + nums[i-1]);
//            }
        }
        return dp[N][0];
    }
}
