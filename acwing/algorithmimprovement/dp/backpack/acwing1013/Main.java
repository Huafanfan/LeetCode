package acwing.algorithmimprovement.dp.backpack.acwing1013;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/20 14:21
 */
public class Main {
    static int N = 11;
    static int M = 16;
    static int[][] f = new int[N][M];
    static int[][] w = new int[N][M];

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                w[i][j] = in.nextInt();
            }
        }
        for (int i=1; i<=n; i++){
            for (int j=0; j<=m; j++){
                for (int k=0; k<=j; k++){
                    f[i][j] = Math.max(f[i][j], f[i-1][j-k] + w[i][k]);
                }
            }
        }
        System.out.println(f[n][m]);

        int j=m;
        int[] way = new int[N];
        for (int i=n; i!=0; i--){
            for (int k=0; k<=j; k++){
                if (f[i][j] == f[i-1][j-k] + w[i][k]){
                    way[i] = k;
                    j -= k;
                    break;
                }
            }
        }
        for (int i=1; i<=n; i++){
            System.out.println(i + " " + way[i]);
        }
    }
}
