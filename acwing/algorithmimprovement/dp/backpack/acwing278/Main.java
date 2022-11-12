package acwing.algorithmimprovement.dp.backpack.acwing278;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/11/12 16:07
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        int[] f = new int[m+1];
        f[0] = 1;
        while (n-- != 0){
            int v = in.nextInt();
            for (int j = m; j>=v; j--){
                f[j] += f[j-v];
            }
        }
        System.out.println(f[m]);
    }
}
