package acwing.algorithmbasic.greedy.sortinginequality.acwing913;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/29 16:24
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] t = new int[n];
        for (int i=0; i<n; i++){
            t[i] = in.nextInt();
        }
        Arrays.sort(t);
        long res = 0;
        for (int i=0; i<n; i++){
            res += (long) t[i] * (n - i - 1);
        }
        System.out.println(res);
    }
}
