package acwing.everyday.acwing4656;

import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2023/1/10 21:45
 */
public class Main {
    static int N = 100010;
    static int n, m;
    static int[] a = new int[N], b = new int[N];

    static boolean check(int mid){
        long res = 0;
        for (int i=0; i<n; i++){
            if (a[i] >= mid){
                res += (a[i] - mid) / b[i] + 1;
            }
        }
        return res >= m;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i=0; i<n; i++){
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }

        int l = 0, r = (int) 1e6;
        while (l < r){
            int mid = l + r + 1>> 1;
            if (check(mid)){
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        long res = 0, cnt = 0;
        for (int i=0; i<n; i++){
            if (a[i] >= r){
                int c = (a[i] - r) / b[i] + 1;
                int end = a[i] - (c-1) * b[i];
                cnt += c;
                res += (long) (a[i] + end) * c / 2;
            }
        }
        System.out.println(res - (cnt - m) * r);
    }
}
