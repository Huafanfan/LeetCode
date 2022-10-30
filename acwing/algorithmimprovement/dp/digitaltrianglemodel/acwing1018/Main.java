package acwing.algorithmimprovement.dp.digitaltrianglemodel.acwing1018;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/30 16:36
 */
public class Main {
    public static void main(String[] args) {
        int N = 110;
        int[][] w = new int[N][N];
        int[][] f = new int[N][N];
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                w[i][j] = in.nextInt();
            }
        }
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                if (i == 1 && j == 1){
                    f[i][j] = w[i][j];
                } else {
                    f[i][j] = Integer.MAX_VALUE;
                    if (i > 1){
                        f[i][j] = Math.min(f[i][j], f[i-1][j] + w[i][j]);
                    }
                    if (j > 1){
                        f[i][j] = Math.min(f[i][j], f[i][j-1] + w[i][j]);
                    }
                }
            }
        }
        System.out.println(f[n][n]);
    }
}
