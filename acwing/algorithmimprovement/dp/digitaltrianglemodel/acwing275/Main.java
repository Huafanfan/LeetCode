package acwing.algorithmimprovement.dp.digitaltrianglemodel.acwing275;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/30 17:29
 */
public class Main {
    static int N = 55;
    static int[][][] f = new int[N + N][N][N];
    static int[][] w = new int[N][N];
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                w[i][j] = in.nextInt();
            }
        }
        for (int k=2; k<=n+m; k++){
            for (int i1 = 1 ; i1 <= n ; i1 ++ )
            {
                for (int i2 = 1 ; i2 <= n ; i2 ++ ){
                    int j1 = k - i1,j2 = k - i2;
                    //判断他们这些纵坐标有没有越界
                    if (j1 >= 1 && j1 <= m && j2 >= 1 && j2 <= m){

                        int t = w[i1][j1];
                        if(i1 != i2) {
                            t += w[i2][j2];
                        }
                        f[k][i1][i2] = Math.max(f[k][i1][i2],f[k - 1][i1 - 1][i2 - 1] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2],f[k - 1][i1][i2 - 1] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2],f[k - 1][i1 - 1][i2] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2],f[k - 1][i1][i2] + t);
                    }
                }
            }
        }
        System.out.println(f[n+m][n][n]);
    }
}
