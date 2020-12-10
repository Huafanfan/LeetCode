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
        int[] v=new int[N+1];
        int[] w=new int[N+1];
        int[] s=new int[N+1];
        int[] backupS = new int[N+1];
        for(int i=1;i<=N;i++){
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
            for (int j = v[i]; j<=V; j++){
                for (int k=0; k<=s[i]; k++){
                    if (j >= k * v[i]){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - k * v[i]] + k*w[i]);
                    }
                }
            }
        }
        System.out.println(dp[N][V]);

        int[] dp1 = new int[V+1];
        for (int i=1; i<=N; i++){
            for (int j=V; j>=v[i]; j--){
                for (int k=1; k<=s[i]&&k*v[i]<=j; k++){
                    dp1[j] = Math.max(dp1[j], dp1[j - k * v[i]] + k*w[i]);
                }
            }
        }
        System.out.println(dp1[V]);

        /**
         * 类似于完全背包拆分为01背包的思路，使用二进制数来表示每个物品所有可能的选取的个数
         * 转化为01背包问题，把物品数量拆成二进制组合，组合数能取到0~s中任意一个数
         */
        List<good> goods=new ArrayList<>();
        for(int i=1;i<=N;i++){
            for(int k=1;k<=s[i];k=k*2){
                s[i]=s[i]-k;
                goods.add(new good(k*v[i],k*w[i]));
            }
            if(s[i]>0){
                goods.add(new good(s[i]*v[i],s[i]*w[i]));
            }
        }
        int[] dp2=new int[V+1];
        for (good g : goods){
            for(int j=V;j>=g.v;j--){
                dp2[j]=Math.max(dp2[j],dp2[j-g.v]+g.w);
            }
        }
        System.out.println(dp2[V]);

        /**
         * 单调队列
         */
        int[] dp5 = new int[V+1];
        int[] pre = new int[V+1];
        int[] q = new int[V+1];
        for (int i=1; i<=N; i++){
            System.arraycopy(dp5, 0, pre, 0, dp5.length);
            for (int j=0; j<v[i]; j++){
                /*
                head为队首位置
                tail为队尾位置
                数值越大，表示位置越后面
                队首在队尾后面队列为空，即head>tail时队列为空
                */
                int head = 0, tail = -1;
                /*
                q[]为单调队列
                存储前个s(物品数量)中的最大值
                数组从头(head)到尾(tail)单调递减
                */
                for (int k=j; k<=V; k += v[i]){
                    //k代表假设当前背包容量为k
                    //q[head]为队首元素（最大值的下标）
                    //pre[]为dp[i-1][]
                    //dp5[]为dp[i][]
                    /*
                    维护一个大小为k的区间
                    使最大值为前k个元素中最大
                    (k - q[head]) / v 表示拿取物品的数量（相当于最原始的多重背包dp的k）
                    */
                    if (head <= tail && (k - q[head]) / v[i] > s[i]){
                        ++head;
                    }

                    /*
                    若队内有值，该值就是前k个元素的最大值
                    (k - q[head]) / v 表示拿取物品的数量（相当于最原始的多重背包dp的k）
                    q[head]为队首元素（pre[]中前k个数中最大值的下标），pre[]为dp[i-1][]
                    所以 pre[q[head]]为只考虑前i-1个物品时，拿前q[head]个物品的最大价值
                    */
                    if (head <= tail){
                        dp5[k] = Math.max(dp5[k], pre[q[head]] + (k - q[head]) / v[i] * w[i]);
                        //dp5[k] = pre[q[head]] + (k - q[head])/v[i] * w[i];
                    }

                    /*
                    若队尾元素小于当前元素，则队尾元素出队；
                    若队内一个元素比当前元素小，则该元素一定不会被用到（单调队列思想）
                    pre[q[tail]] + (k - q[tail]) / v * w
                    与
                    pre[k] - (k - j) / v * w
                    分别表示队尾元素的值和当前元素的值
                    */
                    while (head<=tail && pre[q[tail]] - (q[tail] - j) / v[i] * w[i] <= pre[k] - (k - j)/v[i] * w[i]){
                        --tail;
                    }

                    //去除了比当前小的元素，保证队列里的元素都比当前元素大，入队
                    q[++tail] = k;
                }
            }
        }

        System.out.println(dp5[V]);

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
                    dp3[j] = backupS[i];
                }
                else {
                    dp3[j] = -1;
                }
            }
            for (int j=0; j<=V-v[i]; j++){
                if (dp3[j]>0){
                    dp3[j+v[i]] = Math.max(dp3[j+v[i]], dp3[j]-1);
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
                    dp4[j] = backupS[i];
                }
                else if (j < v[i] || dp4[j - v[i]] <= 0){
                    dp4[j] = -1;
                }
                else {
                    dp4[j] = dp4[j - v[i]] - 1;
                }
            }
        }
        System.out.println(Arrays.toString(dp4));
    }
    static class good{
        int v;
        int w;
        public good(int v,int w){
            this.v=v;
            this.w=w;
        }
    }
}

