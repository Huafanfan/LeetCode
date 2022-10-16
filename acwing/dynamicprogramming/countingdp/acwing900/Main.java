package acwing.dynamicprogramming.countingdp.acwing900;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/16 16:22
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        // 完全背包方法
        // f[i][j] 表示只从1~i中选，且总和等于j的方案数
//        int[] f = new int[n+1];
//        f[0] = 1;
//        for (int i=1; i<=n; i++){
//            for (int j=i; j<=n; j++){
//                f[j] = (f[j] + f[j-i]) % 1000000007;
//            }
//        }
//        System.out.println(f[n]);
        // 方法二
        int[][] f = new int[n+1][n+1];
        f[0][0] = 1;
        for (int i=1; i<=n; i++){
            for (int j=1; j<=i; j++){
                f[i][j] = (f[i-1][j-1] + f[i-j][j]) % 1000000007;
            }
        }
        int res = 0;
        for (int i=0; i<=n; i++){
            res = (res + f[n][i]) % 1000000007;
        }
        System.out.println(res);
    }
}
