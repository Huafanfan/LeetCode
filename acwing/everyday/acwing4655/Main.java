package acwing.everyday.acwing4655;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2023/1/9 21:37
 */
public class Main {
    static int N = 100010;

    static int n, m;
    static int[] w = new int[N], s = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i=1; i<=n; i++){
            w[i] = in.nextInt();
        }
        m = in.nextInt();
        while (m-- != 0){
            int l = in.nextInt();
            int r = in.nextInt();
            s[l]++;
            s[r+1]--;
        }
        for (int i=1; i<=n; i++){
            s[i] += s[i-1];
        }


        long sum1 = 0;
        for (int i=1; i<= n; i++){
            sum1 += (long) s[i] * w[i];
        }
        long sum2 = 0;
        Arrays.sort(w, 1, n+1);
        Arrays.sort(s, 1 , n+1);
        for (int i=1; i<= n; i++){
            sum2 += (long) s[i] * w[i];
        }
        System.out.println(sum2 - sum1);
    }
}
