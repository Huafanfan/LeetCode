package acwing.algorithmimprovement.dp.backpack.acwing1020;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/20 12:04
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int v = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] f = new int[v+1][m+1];
        for (int i=0; i<v+1; i++){
            Arrays.fill(f[i], 0x3f3f3f3f);
        }
        f[0][0] = 0;
        for (int i=0; i<n; i++){
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int w = in.nextInt();
            for (int j=v; j>=0; j--){
                for (int k=m; k>=0; k--){
                    f[j][k] = Math.min(f[j][k], f[Math.max(0, j-v1)][Math.max(0, k-v2)] + w);
                }
            }
        }
        System.out.println(f[v][m]);
    }
}
