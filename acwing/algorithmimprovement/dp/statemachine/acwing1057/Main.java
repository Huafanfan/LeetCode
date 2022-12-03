package acwing.algorithmimprovement.dp.statemachine.acwing1057;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/26 23:07
 */
public class Main {
    static int N = 100010, M = 110;
    static int n, m;
    static int[][][] f = new int[N][M][2];
    static int[] w = new int[N];
    static int INF = 0x3f3f3f3f;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        for (int i=1; i<=n; i++){
            w[i] = in.nextInt();
        }
        for(int i = 0 ; i <= n ; i ++ ) {
            for(int j = 0 ; j <= m ; j ++ ) {
                Arrays.fill(f[i][j],-INF);
            }
        }

        for (int i=0; i<=n; i++){
            f[i][0][0] = 0;
        }

        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                f[i][j][0] = Math.max(f[i-1][j][0], f[i-1][j][1] + w[i]);
                f[i][j][1] = Math.max(f[i-1][j][1], f[i-1][j-1][0] - w[i]);
            }
        }

        int res = 0;
        for (int i=0; i<=m; i++){
            res = Math.max(res, f[n][i][0]);
        }

        System.out.println(res);
    }
}
