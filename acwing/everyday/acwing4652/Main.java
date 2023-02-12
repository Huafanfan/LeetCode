package acwing.everyday.acwing4652;

import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2023/1/9 22:01
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next().substring(1, 2));
        int x = 1189, y = 841;
        while (n-- != 0){
            x /= 2;
            if (x < y){
                int tmp = x;
                x = y;
                y = tmp;
            }
        }
        System.out.println(x);
        System.out.println(y);
    }
}
