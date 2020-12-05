package medium.dp;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/25 16:46
 */
public class IntegerBreak0343 {
    public static void main(String[] args) {
        IntegerBreak0343 integerBreak0343 = new IntegerBreak0343();
        System.out.println(integerBreak0343.integerBreakPro(10));
    }
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for (int i=2; i<=n; i++){
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
    public int integerBreakPro(int n) {
        int border = 4;
        if (n < border){
            return n-1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b==0){
            return (int)Math.pow(3,a);
        }
        else if (b==1){
            return (int)Math.pow(3,a-1) * 4;
        }
        else {
            return (int)Math.pow(3,a) * 2;
        }
    }
}
