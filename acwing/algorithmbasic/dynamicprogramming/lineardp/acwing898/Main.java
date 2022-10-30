package acwing.algorithmbasic.dynamicprogramming.lineardp.acwing898;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/5 17:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
//        int[][] w = new int[n+1][n+1];
//        int[][] f = new int[n+1][n+1];
//        for (int i=1; i<=n; i++){
//            for (int j=1; j<=i; j++){
//                w[i][j] = in.nextInt();
//            }
//        }
//        for (int i=1; i<=n; i++){
//            f[n][i] = w[n][i];
//        }
//        for (int i=n-1; i!=0; i--){
//            for (int j=1; j<=i; j++){
//                f[i][j] = Math.max(f[i+1][j], f[i+1][j+1]) + w[i][j];
//            }
//        }
//        System.out.println(f[1][1]);

        int[][] f = new int[n+1][n+1];
        for (int i=1; i<=n; i++){
            for (int j=1; j<=i; j++){
                f[i][j] = in.nextInt();
            }
        }
        for (int i=n-1; i!=0; i--){
            for (int j=1; j<=i; j++){
                f[i][j] += Math.max(f[i+1][j], f[i+1][j+1]);
            }
        }
        System.out.println(f[1][1]);
    }
}
