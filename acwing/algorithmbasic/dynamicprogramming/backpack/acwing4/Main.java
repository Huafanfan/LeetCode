package acwing.algorithmbasic.dynamicprogramming.backpack.acwing4;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/5 16:38
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();

        int[] v = new int[n+1];
        int[] w = new int[n+1];
        int[] s = new int[n+1];

        int[] f = new int[m+1];

        for (int i=1; i<=n; i++){
            v[i] = in.nextInt();
            w[i] = in.nextInt();
            s[i] = in.nextInt();
        }

        for (int i=1; i<=n; i++){
            for (int j=m; j>=v[i]; j--){
                for (int k=1; k<=s[i] && k * v[i] <= j; k++){
                    f[j] = Math.max(f[j], f[j-k*v[i]] + k*w[i]);
                }
            }
        }
        System.out.println(f[m]);
    }
}
