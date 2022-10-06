package acwing.dynamicprogramming.lineardp.acwing896;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/10/6 15:34
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] a = new int[n+1];
        int[] q = new int[n+1];
        for (int i=0; i<n; i++){
            a[i] = in.nextInt();
        }
        int maxLen = 0;
        q[0] = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            int l = 0, r = maxLen;
            while (l < r){
                int m = l + r + 1 >> 1;
                if (q[m] < a[i]){
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            // a[r]是小于a[i]的最大的数
            maxLen = Math.max(maxLen, r + 1);
            q[r + 1] = a[i];
        }
        System.out.println(maxLen);
    }
}
