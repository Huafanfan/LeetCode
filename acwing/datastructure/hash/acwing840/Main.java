package acwing.datastructure.hash.acwing840;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/12 4:27 PM
 */
public class Main {
    /**
     * 拉链法
     * 100003 大于 100000的第一个质数
     */
//    static int N = 100003;
//    static int[] h = new int[N];
//    static int[] e = new int[N];
//    static int[] ne = new int[N];
//    static int index;

    /**
     * 开放寻址法
     * 200003 大于 200000的第一个质数
     */
    static int N = 200003;
    static int[] h = new int[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        Arrays.fill(h, Integer.MAX_VALUE);
        while (n-- != 0){
            String cmd = in.next();
            int x = in.nextInt();
            int k = find(x);
            if ("I".equals(cmd)){
                h[k] = x;
            } else {
                if (h[k] != Integer.MAX_VALUE){
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    /**
     * 拉链法
     */
//    static void insert(int x){
//        int k = (x % N + N) % N;
//
//        e[index] = x;
//        ne[index] = h[k];
//        h[k] = index;
//        index++;
//    }
//
//    static boolean find(int x){
//        int k = (x % N + N) % N;
//        for (int i=h[k]; i != -1; i = ne[i]){
//            if (e[i] == x){
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     * 开放寻址法
     */
    static int find(int x){
        int k = (x % N + N) % N;
        while (h[k] != Integer.MAX_VALUE && h[k] != x){
            k++;
            if (k == N){
                k++;
            }
        }
        return k;
    }
}
