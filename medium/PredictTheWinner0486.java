package medium;

public class PredictTheWinner0486 {
    public boolean PredictTheWinner(int[] nums) {
        return total(nums, 0, nums.length-1, 1) >= 0;
    }

    public int total(int[] nums, int start, int end, int turn){
        if (start == end){
            return nums[start] * turn;
        }
        int scoreStart = nums[start] * turn + total(nums, start + 1, end, -turn);
        int scoreEnd = nums[end] * turn + total(nums, start, end - 1, -turn);
        //return Math.max(scoreStart * turn, scoreEnd * turn) * turn;
        if(turn == 1){
            return Math.max(scoreStart , scoreEnd);
        }else{
            return Math.min(scoreStart , scoreEnd);
        }
    }

    public boolean PredictTheWinner2(int[] nums) {
        int length = nums.length;
        //dp[i][j] 表示当数组剩下的部分为下标 i 到下标 j 时，当前玩家与另一个玩家的分数之差的最大值
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                //A在本轮领先的分数等于A在本轮选择得到的分数减去B在次轮领先的分数
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }
}
