package acwing.algorithmimprovement.dp.backpack.acwing423;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/6 18:08
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int m = in.nextInt();
        int n = in.nextInt();
        int[] f = new int[m+1];
        for (int i=1; i<=n; i++){
            int v = in.nextInt();
            int w = in.nextInt();
            for (int j=m; j>=v; j--){
                f[j] = Math.max(f[j], f[j-v] + w);
            }
        }
        System.out.println(f[m]);
    }
}
