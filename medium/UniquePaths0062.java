package medium;
import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/4 13:57
 */
public class UniquePaths0062 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //第一行和第一列都只有只有一种方法可以到达
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                //dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 只需要关注当前行和上一行
                cur[j] = cur[j-1] + pre[j];
            }
            //pre用来保存上一行
            pre = cur.clone();
        }
        return pre[n-1];
    }

    public int uniquePaths3(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                //cur[j]还未更新，表示上一行，cur[j-1]已经更新，便是当前行元素的上一个元素
                cur[j] = cur[j] + cur[j-1] ;
            }
        }
        return cur[n-1];
    }

    public int uniquePaths4(int m, int n) {
        //只跟第几行第几列有关，从m+n-2步中抽出m-1步
        long ans=1;
        for(int i=0;i<Math.min(m-1,n-1);i++){
            ans*=m+n-2-i;
            ans/=i+1;
        }
        return (int)ans;
    }
}
