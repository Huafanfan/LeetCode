package acwing.datastructure.queue.acwing829;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/3 5:56 PM
 */
public class Main {
    static int N = 100010;
    static int[] q = new int[N];
    static int hh = 0;
    static int tt = -1;

    static void push(int num){
        q[++tt] = num;
    }

    static void pop(){
        hh++;
    }

    static String empty(){
        return hh <= tt ? "NO" : "YES";
    }

    static int query(){
        return q[hh];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int m = in.nextInt();
        while (m-- > 0){
            String cmd = in.next();
            if ("push".equals(cmd)){
                push(in.nextInt());
            } else if ("pop".equals(cmd)){
                pop();
            } else if ("empty".equals(cmd)){
                System.out.println(empty());
            } else {
                System.out.println(query());
            }
        }
    }
}
