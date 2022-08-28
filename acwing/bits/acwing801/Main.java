package acwing.bits.acwing801;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/8/28 5:09 PM
 */
public class Main {
    /**
     * 第k位是0或者1 => x>>k&1
     * lowbit(x) => x&-x
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        while (n-- > 0){
            int num = in.nextInt();
            int count = 0;
            while (num != 0){
                num = num & num - 1;
                count++;
            }
            System.out.print(count + " ");
        }
    }
}
