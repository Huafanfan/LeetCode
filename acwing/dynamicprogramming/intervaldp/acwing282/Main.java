package acwing.dynamicprogramming.intervaldp.acwing282;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/16 16:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] s = new int[n+1];
        int[][] f = new int[n+1][n+1];
        for (int i=1; i<=n; i++){
            s[i] = in.nextInt();
            s[i] += s[i-1];
        }
        for (int len = 2; len<=n; len++){
            for (int i=1; i + len - 1 <=n; i++){
                int j = i + len - 1;
                f[i][j] = Integer.MAX_VALUE;
                for (int k=i; k<j; k++){
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k+1][j] + s[j] - s[i-1]);
                }
            }
        }
        System.out.println(f[1][n]);
    }
}
