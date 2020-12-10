package packproblem;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/10 16:21
 */
public class SpecificPlan {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int V=sc.nextInt();
        int[] v=new int[N+1];
        int[] w=new int[N+1];
        int[][] dp = new int[N+2][V+1];
        for(int i=1;i<=N;i++){
            v[i]=sc.nextInt();
            w[i]=sc.nextInt();
        }
        //dp(i,j)定义为从第i个元素到最后一个元素总容量为j的最优解
        for (int i=N; i>=1; i--){
            for (int j=0; j<=V; j++){
                dp[i][j] = dp[i+1][j];
                if (j >= v[i]){
                    dp[i][j] = Math.max(dp[i][j], dp[i+1][j-v[i]] + w[i]);
                }
            }
        }
        int curV = V;
        StringBuilder result = new StringBuilder();
        for (int i=1; i<=N; i++){
            if (i==N && curV >= v[i]){
                result.append(i);
                //System.out.println(i);
                break;
            }
            if (curV <= 0){
                break;
            }
            if (curV - v[i] >=0 && dp[i][curV] == dp[i+1][curV - v[i]] + w[i]){
                result.append(i);
                result.append(" ");
                //System.out.println(i);
                curV -= v[i];
            }
        }
        System.out.println(result.toString());
    }
}
