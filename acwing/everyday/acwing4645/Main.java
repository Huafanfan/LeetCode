package acwing.everyday.acwing4645;

import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/12/31 23:07
 */
public class Main {
    static int N = 100010, M = (1 << 20) + 10;

    static int n, m, x;
    static int[] last = new int[M], g = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        x = in.nextInt();

        for (int i=1; i<=n; i++){
            int a = in.nextInt();
            g[i] = Math.max(g[i-1], last[a ^ x]);
            last[a] = i;
        }

        while (m-- != 0){
            int l = in.nextInt();
            int r = in.nextInt();
            if (g[r] >= l){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
