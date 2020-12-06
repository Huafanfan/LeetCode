package medium.dp;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/28 11:31
 */
public class PartitionEqualSubsetSum0416 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,11,5};
        PartitionEqualSubsetSum0416 partitionEqualSubsetSum0416 = new PartitionEqualSubsetSum0416();
        System.out.println(partitionEqualSubsetSum0416.canPartition1(nums));
    }
    public boolean canPartition1(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }

        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        if (maxNum > target){
            return false;
        }

        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][target + 1];
        for (int i=0; i<len; i++){
            dp[i][0] = true;
        }

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        //dp[i][j] 表示从数组的 [0,i] 下标范围内选取若干个正整数（可以是 0 个），是否存在一种选取方案使得被选取的正整数的和等于 j
        dp[0][nums[0]] = true;

        for (int i = 1; i < len; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (num <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                }
                else {
                    dp[i][j] = dp[i -1][j];
                }
            }
        }
        return dp[len - 1][target];
    }

    public boolean canPartition2(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target){
            return false;
        }

        boolean[] dp = new boolean[target + 1];
        //dp[0]=true相当于之前的dp[i][0]=true
        dp[0] = true;
        //dp[nums[0]]=true相当于之前的dp[0][nums[0]]=true
        dp[nums[0]] = true;

        for (int i=1; i<len; i++){
            int num = nums[i];
            for (int j = target; j>=num; j--){
                //这里是从后向前，从前向后会修改后续用到的i-1行的值
                dp[j] = dp[j] || dp[j-num];
            }
        }
        return dp[target];
    }

    public boolean canPartition3(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 == 1) {
            return false;
        }
        int C = sum/2;
        if (maxNum > C){
            return false;
        }
        boolean[][] dp = new boolean[n][C+1];
        for (int i=0; i<n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i=1; i<n; i++) {
            for (int j=1; j<=C; j++){
                if (j >= nums[i]) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][C];
    }

    public boolean canPartition4(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 == 1) {
            return false;
        }
        int C = sum/2;
        if (maxNum > C){
            return false;
        }
        boolean[] dp = new boolean[C+1];
        dp[0] = true;
        dp[nums[0]] = true;
        for (int i=1; i<n; i++) {
            for (int j=C; j>=nums[i]; j--){
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[C];
    }

}
