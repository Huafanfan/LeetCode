package packproblem;

import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/9 15:00
 */
public class TwoDimensionalCostPack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int V=sc.nextInt();
        int M=sc.nextInt();
        int[] v=new int[N];
        int[] m=new int[N];
        int[] w=new int[N];
        for(int i=0;i<N;i++){
            v[i]=sc.nextInt();
            m[i]=sc.nextInt();
            w[i]=sc.nextInt();
        }
        int[][] dp=new int[V+1][M+1];
        for(int i=1;i<=N;i++){
            for(int j=V;j>=v[i-1];j--){
                for(int k=M;k>=m[i-1];k--){
                    dp[j][k]=Math.max(dp[j][k],dp[j-v[i-1]][k-m[i-1]]+w[i-1]);
                }
            }
        }
        System.out.println(dp[V][M]);
    }
}
