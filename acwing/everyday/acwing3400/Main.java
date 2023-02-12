package acwing.everyday.acwing3400;

import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/12/29 21:54
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int res = 0;
        for (int i=1; i<=n; i++){
            int num = i;
            while (num != 0){
                int last = num % 10;
                num /= 10;
                if (last == k){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
