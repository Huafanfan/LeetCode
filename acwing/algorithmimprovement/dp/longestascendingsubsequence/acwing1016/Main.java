package acwing.algorithmimprovement.dp.longestascendingsubsequence.acwing1016;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/5 16:50
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] a = new int[n+1];
        int[] f = new int[n+1];
        for (int i=1; i<=n; i++){
            a[i] = in.nextInt();
        }
        int res = 0;
        for (int i=1; i<=n; i++){
            f[i] = a[i];
            for (int j=1; j<i; j++){
                if (a[j] < a[i]){
                    f[i] = Math.max(f[i], f[j] + a[i]);
                }
            }
            res = Math.max(res, f[i]);
        }
        System.out.println(res);
    }
}
