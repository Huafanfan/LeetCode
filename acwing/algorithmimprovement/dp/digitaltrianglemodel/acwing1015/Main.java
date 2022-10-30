package acwing.algorithmimprovement.dp.digitaltrianglemodel.acwing1015;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/30 16:19
 */
public class Main {
    public static void main(String[] args) {
        int N = 110;
        int[][] w = new int[N][N];
        int[][] f = new int[N][N];
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int T = in.nextInt();
        while (T -- != 0){
            int n = in.nextInt();
            int m = in.nextInt();
            for (int i=1; i<=n; i++){
                for (int j=1; j<=m; j++){
                    w[i][j] = in.nextInt();
                }
            }
            for (int i=1; i<=n; i++){
                for (int j=1; j<=m; j++){
                    f[i][j] = Math.max(f[i-1][j], f[i][j-1]) + w[i][j];
                }
            }
            System.out.println(f[n][m]);
        }
    }
}
