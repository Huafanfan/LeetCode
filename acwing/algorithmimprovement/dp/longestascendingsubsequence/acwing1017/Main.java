package acwing.algorithmimprovement.dp.longestascendingsubsequence.acwing1017;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/5 15:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int T = in.nextInt();
        int[] a = new int[110];
        int[] f = new int[110];
        while (T-- !=0){
            int n = in.nextInt();
            for (int i=1; i<=n; i++){
                a[i] = in.nextInt();
            }
            // 正向求解LIS问题
            int res = 0;
            for (int i=1; i<=n; i++){
                f[i] = 1;
                for (int j=1; j<i; j++){
                    if (a[i] > a[j]){
                        f[i] = Math.max(f[i], f[j] + 1);
                    }
                }
                res = Math.max(res, f[i]);
            }

            for (int i=n; i>=1; i--){
                f[i] = 1;
                for (int j=n; j>i; j--){
                    if (a[i] > a[j]){
                        f[i] = Math.max(f[i], f[j] + 1);
                    }
                }
                res = Math.max(res, f[i]);
            }
            System.out.println(res);
        }

    }
}
