package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/4/11 08:49
 */
public class CountNumbersWithUniqueDigits0357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 10;
        for (int i=2; i<=n; i++){
            dp[i] = dp[i-1] +  (dp[i-1] - dp[i-2])*(10-(i-1));
        }
        return dp[n];
    }

    public int countNumbersWithUniqueDigits2(int n) {
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return 10;
        }
        int res = 10;
        int count = 9;
        for (int i=0; i<n-1; i++){
            count *= 9-i;
            res += count;
        }
        return res;
    }
}
