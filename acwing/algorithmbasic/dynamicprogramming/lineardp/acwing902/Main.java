package acwing.algorithmbasic.dynamicprogramming.lineardp.acwing902;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/6 16:32
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        String a = in.next();
        int m = in.nextInt();
        String b = in.next();
        int[][] f = new int[n+1][m+1];
        for (int i=0; i<=m; i++){
            f[0][i] = i;
        }
        for (int i=0; i<=n; i++){
            f[i][0] = i;
        }
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                f[i][j] = Math.min(f[i-1][j] + 1, f[i][j-1] + 1);
                if (a.charAt(i-1) == b.charAt(j-1)){
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1]);
                } else {
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1] + 1);
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
