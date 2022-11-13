package acwing.algorithmimprovement.dp.backpack.acwing7;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/13 17:14
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        int[] f = new int[m+1];

        for (int i=0; i<n; i++){
            int v = in.nextInt();
            int w = in.nextInt();
            int s = in.nextInt();
            if (s == 0){
                // 完全背包问题
                for (int j=v; j<=m; j++){
                    f[j] = Math.max(f[j], f[j-v] + w);
                }
            } else {
                if (s == -1){
                    s = 1;
                }
                for (int k=1; k<=s; k++){
                    for (int j=m; j>=k*v; j--){
                        f[j] = Math.max(f[j], f[j-k*v] + k*w);
                    }
                    s -= k;
                }
                if (s != 0){
                    for (int j=m; j>=s*v; j--){
                        f[j] = Math.max(f[j], f[j-s*v] + s*w);
                    }
                }
            }
        }
        System.out.println(f[m]);
    }
}
