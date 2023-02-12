package acwing.everyday.acwing4818;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/12/30 18:03
 */
public class Main {
    public static void main(String[] args) {
        long total = 0;
        int max = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] cows = new int[n];
        for (int i=0; i<n; i++){
            cows[i] = in.nextInt();
        }
        Arrays.sort(cows);
        for (int i=0; i<n; i++){
            long cur = (long) cows[i] * (n-i);
            if (cur > total){
                total = cur;
                max = cows[i];
            }
        }
        System.out.println(total + " " + max);
    }
}
