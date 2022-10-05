package acwing.dynamicprogramming.backpack.acwing2;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 01背包
 * @author yifan.zhangyf
 * @date 2022/10/5 13:25
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();

        int[] v = new int[n+1];
        int[] w = new int[n+1];

//        // 朴素写法
//        int[][] f = new int[n+1][m+1];
//
//        for (int i=1; i<=n; i++){
//            v[i] = in.nextInt();
//            w[i] = in.nextInt();
//        }
//
//        for (int i=1; i<=n; i++){
//            for (int j=0; j<=m; j++){
//                f[i][j] = f[i-1][j];
//                if (j >= v[i]){
//                    f[i][j] = Math.max(f[i][j], f[i-1][j-v[i]] + w[i]);
//                }
//            }
//        }
//        System.out.println(f[n][m]);
        // 优化写法
        int[] f = new int[m+1];

        for (int i=1; i<=n; i++){
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        for (int i=1; i<=n; i++){
            for (int j=m; j>=v[i]; j--){
                f[j] = Math.max(f[j], f[j-v[i]] + w[i]);
            }
        }
        System.out.println(f[m]);
    }
}
