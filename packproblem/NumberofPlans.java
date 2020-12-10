package packproblem;

import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/9 15:25
 */
public class NumberofPlans {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int mod=1000000007;
        int N=sc.nextInt();
        int V=sc.nextInt();
        int[] v=new int[N+1];
        int[] w=new int[N+1];
        for(int i=1;i<=N;i++){
            v[i]=sc.nextInt();
            w[i]=sc.nextInt();
        }
        int[] dp=new int[V+1];
        int[] count=new int[V+1];
        for(int i=0;i<=V;i++){
            count[i]=1;
        }
        for(int i=1;i<=N;i++){
            for(int j=V;j>=v[i];j--){
                int value=dp[j-v[i]]+w[i];
                if(value>dp[j]){
                    dp[j]=value;
                    count[j]=count[j-v[i]];
                }else if(value==dp[j]){
                    // 有两条路径
                    count[j]=(count[j-v[i]]+count[j])%mod;
                }
            }
        }
        System.out.println(count[V]);
    }
}
