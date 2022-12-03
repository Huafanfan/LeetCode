package acwing.algorithmimprovement.dp.statemachine.acwing1049;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/26 23:07
 */
public class Main {
    static int N = 100010;
    static int n;
    static int[][] f = new int[N][2];
    static int[] w = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int T = in.nextInt();
        while (T-- != 0){
            n = in.nextInt();
            for (int i=1; i<=n; i++){
                w[i] = in.nextInt();
            }

            f[0][0] = 0;
            f[0][1] = Integer.MIN_VALUE;
            for (int i=1; i<=n; i++){
                f[i][0] = Math.max(f[i-1][0], f[i-1][1]);
                f[i][1] = f[i-1][0] + w[i];
            }
            System.out.println(Math.max(f[n][0], f[n][1]));
        }
    }
}
