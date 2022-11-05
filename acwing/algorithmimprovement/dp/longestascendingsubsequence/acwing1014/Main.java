package acwing.algorithmimprovement.dp.longestascendingsubsequence.acwing1014;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/5 15:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int[] a = new int[1010];
        int[] f = new int[1010];
        int[] g = new int[1010];

        int n = in.nextInt();
        for (int i=1; i<=n; i++){
            a[i] = in.nextInt();
        }

        for (int i=1; i<=n; i++){
            f[i] = 1;
            for (int j=1; j<i; j++){
                if (a[i] > a[j]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        for (int i=n; i>=1; i--){
            g[i] = 1;
            for (int j=n; j>i; j--){
                if (a[i] > a[j]){
                    g[i] = Math.max(g[i], g[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i=1; i<=n; i++){
            res = Math.max(res, f[i] + g[i] - 1);
        }

        System.out.println(res);
    }
}
