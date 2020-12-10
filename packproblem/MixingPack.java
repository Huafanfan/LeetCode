package packproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/9 14:38
 */
public class MixingPack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int V=sc.nextInt();
        int[] vArray=new int[N+1];
        int[] wArray=new int[N+1];
        int[] sArray=new int[N+1];
        List<Thing> things=new ArrayList<>();
        for(int i=1;i<=N;i++){
            int v=sc.nextInt();
            vArray[i] = v;
            int w=sc.nextInt();
            wArray[i] = w;
            int s=sc.nextInt();
            sArray[i] = s;
            if(s<0){
                things.add(new Thing(-1,v,w));
            }else if(s==0){
                things.add(new Thing(0,v,w));
                // 多重背包转化为01背包
            }else{
                for(int k=1;k<=s;k=k*2){
                    s=s-k;
                    things.add(new Thing(-1,k*v,k*w));
                }
                if(s>0){
                    things.add(new Thing(-1,s*v,s*w));
                }
            }
        }
        int[] dp=new int[V+1];
        for(int i=1;i<=things.size();i++){
            int kind=things.get(i-1).kind;
            if(kind<0){
                // 01背包，体积从大到小遍历
                for(int j=V;j>=things.get(i-1).v;j--){
                    dp[j]=Math.max(dp[j],dp[j-things.get(i-1).v]+things.get(i-1).w);
                }
            }else{
                // 完全背包，体积从小到大遍历
                for(int j=things.get(i-1).v;j<=V;j++){
                    dp[j]=Math.max(dp[j],dp[j-things.get(i-1).v]+things.get(i-1).w);
                }
            }
        }
        System.out.println(dp[V]);

        int[] dp1=new int[V+1];
        for (int i=1; i<=N; i++){
            if (sArray[i]==-1){
                for (int j=V; j>= vArray[i]; j--){
                    dp1[j] = Math.max(dp1[j],dp1[j-vArray[i]] + wArray[i]);
                }
            }
            if (sArray[i]==0){
                for (int j=vArray[i]; j<= V; j++){
                    dp1[j] = Math.max(dp1[j],dp1[j-vArray[i]] + wArray[i]);
                }
            }
            if (sArray[i]>0){
                for (int j=V; j>=vArray[i]; j--){
                    for (int k=0; k<=sArray[i]; k++){
                        if (j >= k * vArray[i]){
                            dp1[j] = Math.max(dp1[j], dp1[j - k * vArray[i]] + k*wArray[i]);
                        }
                    }
                }
            }
        }
        System.out.println(dp1[V]);
    }
}
class Thing{
    int kind;
    int v;
    int w;
    public Thing(int kind,int v,int w){
        this.kind=kind;
        this.v=v;
        this.w=w;
    }
}
