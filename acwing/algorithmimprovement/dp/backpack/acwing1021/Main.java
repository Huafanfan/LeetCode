package acwing.algorithmimprovement.dp.backpack.acwing1021;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/12 16:55
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        long[] f = new long[m+1];
        f[0] = 1;
        for (int i=1; i<=n; i++){
            int v = in.nextInt();
            for (int j=0; j<=m; j++){
                if (j >= v){
                    f[j] += f[j - v];
                }
            }
        }
        System.out.println(f[m]);
    }
}
