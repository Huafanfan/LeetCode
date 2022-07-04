package acwing.binary.acwing790;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/1 15:48
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        double n = in.nextDouble();
        double l = -10000, r = 10000;
        // 找到第一个小于等的，所以 >= x ，抛弃右边，往左走。
        while (r - l > 1e-8){
            double mid = (l + r) / 2;
            if (Math.pow(mid, 3) >= n){
                r = mid;
            } else {
                l = mid;
            }
        }
        System.out.printf("%f\n", l);
    }
}
