package acwing.dynamicprogramming.lineardp.acwing897;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/6 16:11
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        String a = in.next();
        String b = in.next();
        int[][] f = new int[n+1][m+1];
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
                if (a.charAt(i-1) == b.charAt(j-1)){
                    f[i][j] = Math.max(f[i][j], f[i-1][j-1] + 1);
                }
            }
        }
        System.out.println(f[n][m]);

    }
}
