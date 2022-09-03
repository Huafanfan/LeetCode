package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yifan.zhangyf
 * @date 2022/9/3 11:45 AM
 */
public class MaximumLengthOfPairChain0646 {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i=0; i<n; i++){
            for (int j=0; j<i; j++){
                if (pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n-1];
    }

    public int findLongestChain2(int[][] pairs) {
        int cur = Integer.MIN_VALUE, res = 0;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        for (int[] pair : pairs){
            if (cur < pair[0]){
                cur = pair[1];
                res++;
            }
        }
        return res;
    }
}
