package acwing.dynamicprogramming.lineardp.acwing899;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/6 16:48
 */
public class Main {

    static int editDistance(String a, String b){
        int n = a.length();
        int m = b.length();
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
                f[i][j] = Math.min(f[i][j], f[i-1][j-1] + (a.charAt(i-1) == b.charAt(j-1) ? 0 : 1));
            }
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        String[] str = new String[n];
        for (int i=0; i<n; i++){
            str[i] = in.next();
        }
        while (m-- != 0){
            String s = in.next();
            int limit = in.nextInt();
            int res = 0;
            for (int i=0; i<n; i++){
                if (editDistance(str[i], s) <= limit){
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
