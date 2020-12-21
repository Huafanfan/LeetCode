package easy.dp;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/2 16:29
 */
public class MinCostClimbingStairs0746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0){
            return 0;
        }
        if (cost.length == 1){
            return cost[0];
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i=2; i<cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i-2], dp[i-1]);
        }
        return Math.min(dp[cost.length-1], dp[cost.length-2]);
    }
    public int minCostClimbingStairs2(int[] cost) {
        int cur = cost[1], last = cost[0];
        for (int i=2; i<cost.length; i++) {
            int temp = cur;
            cur = cost[i] + Math.min(last, cur);
            last = temp;
        }
        return Math.min(last, cur);
    }

    /**
     * 99.68%
     * 95.79%
     * @param cost
     * @return
     */
    public int minCostClimbingStairs3(int[] cost) {
        int prev = 0;
        int cur = 0;
        for (int i=2; i<=cost.length; i++){
            int next = Math.min(cost[i-1 + cur], cost[i-2] + prev);
            prev = cur;
            cur = next;
        }
        return cur;
    }

    public static void main(String[] args) {
        MinCostClimbingStairs0746 minCostClimbingStairs0746  = new MinCostClimbingStairs0746();
        int[] cost = new int[]{10,15,20};
        System.out.println(minCostClimbingStairs0746.minCostClimbingStairs2(cost));
    }
}
