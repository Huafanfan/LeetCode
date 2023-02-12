package acwing.everyday.acwing4699;

import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2023/2/5 12:19
 */
public class Main {
    static int N = 25;
    static int n, m;
    static int[] a = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        for (int i=0; i<n; i++){
            a[i] = in.nextInt();
        }
        for (int i=0; i<n; i++){
            System.out.print(m % a[i] + " ");
            m /= a[i];
        }
    }
}
