package packproblem;

import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/6 11:22
 */
public class ZeroOnePack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int V=sc.nextInt();
        int[] v=new int[N];
        int[] w=new int[N];
        for(int i=0;i<N;i++){
            v[i]=sc.nextInt();
            w[i]=sc.nextInt();
        }
        int[][] dp=new int[N+1][V+1];
        for(int i=1;i<=N;i++){
            for(int j=v[i-1];j<=V;j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-v[i-1]]+w[i-1]);
            }
        }
        System.out.println(dp[N][V]);

        int[] dp2=new int[V+1];
        for(int i=1;i<=N;i++){
            for (int j=V; j>=v[i-1]; j--){
                dp2[j] = Math.max(dp2[j], dp2[j-v[i-1]] + w[i-1]);
            }
        }
        System.out.println(dp2[V]);
    }
}
