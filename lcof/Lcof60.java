package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/23 11:28
 */
public class Lcof60 {
    /**
     * 100.00%
     * 56.14%
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        //int[][] dp = new int[12][70];
        int[] dp = new int[70];
        for (int i=1; i<=6; i++){
            //dp[1][i] = 1;
            dp[i] = 1;
        }
        for (int i=2; i<=n; i++){
            //for (int j=i; j<=6*i; j++){
            //    for (int cur=1; cur<=6; cur++){
            //        if (j <= cur){
            //            break;
            //        }
            //        dp[i][j] += dp[i-1][j-cur];
            //    }
            //}
            for (int j=6*i; j>=i; j--){
                dp[j] = 0;
                for (int cur=1; cur<=6; cur++){
                    if (j - cur < i - 1){
                        break;
                    }
                    dp[j] += dp[j-cur];
                }
            }
        }

        int all = (int)Math.pow(6, n);
        double[] res = new double[5*n + 1];
        int index = 0;
        for (int i=n; i<= 6*n; i++){
            res[index++] = dp[i] * 1.0 / all;
        }
        return res;
    }
}
