package acwing.prefixsum.acwing797;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 */
public class Main {
    static int N = 100010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i=1; i<=n; i++){
            a[i] = in.nextInt();
            // 这里就是在构造b，a是b的前缀和，insert函数表示相对a数组的某个区间加上某个数。初始化a的所有数为0，每对a赋一个值，
            // 就相当于对于对当前i-i区间加上a的值
            insert(i, i, a[i]);
        }
        while (m-- > 0){
            int l = in.nextInt();
            int r = in.nextInt();
            int c = in.nextInt();
            insert(l, r, c);
        }
        for (int i=1; i<n; i++){
            b[i] += b[i-1];
            System.out.print(b[i] + " ");
        }
        b[n] += b[n-1];
        System.out.println(b[n]);
    }
    public static void insert(int l, int r, int c){
        b[l] += c;
        b[r+1] -= c;
    }
}
