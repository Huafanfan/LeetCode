package packproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/6 11:50
 */
public class CompletePack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int V=sc.nextInt();
        int[] v=new int[N+1];
        int[] w=new int[N+1];
        for(int i=1;i<=N;i++){
            v[i]=sc.nextInt();
            w[i]=sc.nextInt();
        }
        /**
         * 下面的方法完全是将完全背包拆分成01背包
         */
        //List<Integer> splitV = new ArrayList<>();
        //List<Integer> splitW = new ArrayList<>();
        //for (int i=0; i<N; i++){
        //    int weight = 0;
        //    int k = 0;
        //    //提升为 O(log ⌊ V /Ci ⌋ )
        //    while (v[i]* (weight =pow(2, k)) <= V){
        //            splitV.add(v[i]*weight);
        //            splitW.add(w[i]*weight);
        //            k++;
        //    }
        //    //int splitNum = V/v[i];
        //    //for (int j=1; j<=splitNum; j++){
        //    //    splitV.add(v[i]);
        //    //    splitW.add(w[i]);
        //    //}
        //}
        //N = splitV.size();
        //int[] dp=new int[V+1];
        //for(int i=1;i<=N;i++){
        //    for (int j=V; j>=splitV.get(i-1); j--){
        //        dp[j] = Math.max(dp[j], dp[j-splitV.get(i-1)] + splitW.get(i-1));
        //    }
        //}
        //System.out.println(dp[V]);

        /**
         * 完全背包的算法
         * 01背包中要按照 v 递减的次序来循环。让 v 递减是为了保证第 i 次循环中的状态 F[i, v] 是由状态 F[i − 1, v − C i ] 递推而来。
         * 完全背包的特点恰是每种物品可选无限件，所以在考虑“加选一件第 i 种物品”这种策略时， 却正需要一个可能已选入第 i 种物品的子结果 F[i, v − C i ]，所以就可以并且必须采用 v 递增的顺序循环。
         */
        int[][] dp1 = new int[N+1][V+1];
        for (int i=1; i<=N; i++){
            for (int j = v[i]; j<=V; j++){
                dp1[i][j] = Math.max(dp1[i-1][j], dp1[i][j-v[i]]+w[i]);
            }
        }
        int[] dp2 = new int[V+1];
        for (int i=1; i<=N; i++){
            for (int j = v[i]; j<=V; j++){
                dp2[j] = Math.max(dp2[j], dp2[j-v[i]]+w[i]);
            }
        }
        System.out.println(dp1[N][V]);
        System.out.println(dp2[V]);
    }

    public static int pow(int num, int k){
        int result = 1;
        while (k>0){
            result *= num;
            k--;
        }
        return result;
    }
}
