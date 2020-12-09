package packproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/9 10:42
 */
public class MultiplePack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int V=sc.nextInt();
        int[] v=new int[N];
        int[] w=new int[N];
        int[] s=new int[N];
        int[] backupS = new int[N];
        for(int i=0;i<N;i++){
            v[i]=sc.nextInt();
            w[i]=sc.nextInt();
            s[i]=sc.nextInt();
        }
        System.arraycopy(s, 0, backupS, 0, s.length);
        /**
         * 多重背包和01背包类似，只是01背包每个物品选择0或1，多重背包每个物品选0或1或。。。到k
         */
        int[][] dp = new int[N+1][V+1];
        for (int i=1; i<=N; i++){
            for (int j = v[i-1]; j<=V; j++){
                for (int k=0; k<=s[i-1]; k++){
                    if (j >= k * v[i - 1]){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - k * v[i - 1]] + k*w[i-1]);
                    }
                }
            }
        }
        System.out.println(dp[N][V]);

        int[] dp1 = new int[V+1];
        for (int i=1; i<=N; i++){
            for (int j=V; j>=v[i-1]; j--){
                for (int k=0; k<=s[i-1]; k++){
                    if (j >= k * v[i - 1]){
                        dp1[j] = Math.max(dp1[j], dp1[j - k * v[i - 1]] + k*w[i-1]);
                    }
                }
            }
        }
        System.out.println(dp1[V]);

        /**
         * 类似于完全背包拆分为01背包的思路，使用二进制数来表示每个物品所有可能的选取的个数
         */
        List<good> goods=new ArrayList<>();
        // 转化为01背包问题，把物品数量拆成二进制组合，组合数能取到0~s中任意一个数
        for(int i=0;i<N;i++){
            for(int k=1;k<=s[i];k=k*2){
                s[i]=s[i]-k;
                goods.add(new good(k*v[i],k*w[i]));
            }
            if(s[i]>0){
                goods.add(new good(s[i]*v[i],s[i]*w[i]));
            }
        }
        int[] dp2=new int[V+1];
        for(int i=1;i<=goods.size();i++){
            for(int j=V;j>=goods.get(i-1).v;j--){
                dp2[j]=Math.max(dp2[j],dp2[j-goods.get(i-1).v]+goods.get(i-1).w);
            }
        }
        System.out.println(dp2[V]);

        /**
         * 可行性问题 O(VN) 的算法 每种有若干件的物品能否填满给定容量的背包
         * 设 F[i, j] 表示“用了前 i 种物品填满容量为 j 的背包后， 最多还剩 下几个第 i 种物品可用”， 如果 F[i, j] = −1 则说明这种状态不可行， 若可行应满足
         * 0 ≤ F[i, j] ≤ M i 。
         */
        int[] dp3 = new int[V+1];
        Arrays.fill(dp3, -1);
        dp3[0] = 0;
        for (int i=1; i<=N; i++){
            for (int j=0; j<=V; j++){
                if (dp3[j]>=0){
                    dp3[j] = backupS[i-1];
                }
                else {
                    dp3[j] = -1;
                }
            }
            for (int j=0; j<=V-v[i-1]; j++){
                if (dp3[j]>0){
                    dp3[j+v[i-1]] = Math.max(dp3[j+v[i-1]], dp3[j]-1);
                }
            }
        }
        System.out.println(Arrays.toString(dp3));

        int[] dp4 = new int[V+1];
        Arrays.fill(dp4, -1);
        dp4[0] = 0;
        for (int i=1; i<=N; i++){
            for (int j=0; j<=V; j++){
                if (dp4[j] >= 0){
                    dp4[j] = backupS[i-1];
                }
                else if (j < v[i-1] || dp4[j - v[i-1]] <= 0){
                    dp4[j] = -1;
                }
                else {
                    dp4[j] = dp4[j - v[i-1]] - 1;
                }
            }
        }
        System.out.println(Arrays.toString(dp4));
    }
}
class good{
    int v;
    int w;
    public good(int v,int w){
        this.v=v;
        this.w=w;
    }
}
