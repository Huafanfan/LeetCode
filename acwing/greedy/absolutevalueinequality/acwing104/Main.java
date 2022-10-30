package acwing.greedy.absolutevalueinequality.acwing104;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/29 16:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++){
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        long res = 0;
        for (int i=0; i<n; i++){
            res += Math.abs(a[i] - a[n/2]);
        }
        System.out.println(res);
    }
}
