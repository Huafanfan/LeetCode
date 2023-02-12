package acwing.everyday.acwing4700;

import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2023/2/5 12:31
 */
public class Main {
    static int N = 33, M = 300010;

    static int n, x;
    static int[] w = new int[N];
    static int[] f = new int[M];
    static int res = (int) 1e8;

    static void dfs(int u, int sum){
        if (u == n){
            if (sum >= x){
                res = Math.min(res, sum);
            }
        }
        dfs(u+1, sum);
        dfs(u+1, sum + w[u]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        x = in.nextInt();

        int sum = 0;
        for (int i=0; i<n; i++){
            w[i] = in.nextInt();
            sum += w[i];
        }

        int m = sum - x;

        //for (int i=0; i < 1<<n; i++){
        //    int sum = 0;
        //    for (int j=0; j<n; j++){
        //        if ((i >> j & 1) == 1){
        //            sum += w[j];
        //        }
        //    }
        //    if (sum >= x){
        //        res = Math.min(res, sum);
        //    }
        //}

        //dfs(0, 0);

        //System.out.println(res);

        // 选择若干本书，使得总和不超过sum-x的前提下，总和越大越好。
        // 转化成背包问题后
        // 背包容量：sum-x
        // 每个物品的体积：w[i]
        // 每个物品的价值：w[i]

        for (int i=0; i<n; i++){
            for (int j = m; j>=w[i]; j--){
                f[j] = Math.max(f[j], f[j - w[i]] + w[i]);
            }
        }

        System.out.println(sum - f[m]);


    }
}
