package acwing.everyday.acwing4454;

import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2023/2/2 23:04
 */
public class Main {
    static int N = 100010;
    static int n, m;
    static boolean[] st = new boolean[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        st[0] = true;
        int res = 0;
        while (m-- != 0){
            int x = in.nextInt();
            int y = in.nextInt();
            if (!st[y]){
                res++;
            }
            st[x] = true;
        }
        System.out.println(res);
    }
}
