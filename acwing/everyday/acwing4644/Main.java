package acwing.everyday.acwing4644;

import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2023/1/3 23:08
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long s1 = 0, s2 = 0;
        while (n-- != 0){
            int x = in.nextInt();
            s1 += x;
            s2 += (long) x * x;
        }
        System.out.println((s1 * s1 - s2) / 2);
    }
}
