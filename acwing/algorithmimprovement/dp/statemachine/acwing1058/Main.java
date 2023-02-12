package acwing.algorithmimprovement.dp.statemachine.acwing1058;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/12/3 21:49
 */
public class Main {
    static int N = 100010, INF = 0x3f3f3f;
    static int n;
    static int[][] f = new int[N][3];
    static int[] w = new int[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        for (int i=1; i<=n; i++){
            w[i] = in.nextInt();
        }
        f[0][0] = -INF;
        f[0][1] = -INF;
        f[0][2] = 0;
        for (int i=1; i<=n; i++){
            f[i][0] = Math.max(f[i-1][0], f[i-1][2] - w[i]);
            f[i][1] = f[i-1][0] + w[i];
            f[i][2] = Math.max(f[i-1][2], f[i-1][1]);
        }
        System.out.println(Math.max(f[n][1], f[n][2]));
    }
}
