package packproblem;

import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/9 15:09
 */
public class GroupingPack {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int V=sc.nextInt();
        int[] dp=new int[V+1];
        for(int i=0;i<N;i++){
            int S=sc.nextInt();
            int[] v=new int[S];
            int[] w=new int[S];
            for(int t=0;t<S;t++){
                v[t]=sc.nextInt();
                w[t]=sc.nextInt();
            }
            // 每组之间是01背包问题
            for(int j=V;j>=0;j--){
                // 组内遍历,所有的决策中选一个，多重背包是分组背包的特殊情况
                for(int k=0;k<S;k++){
                    if(j>=v[k]){
                        dp[j]=Math.max(dp[j],dp[j-v[k]]+w[k]);
                    }
                }
            }
        }
        System.out.println(dp[V]);
    }
}
