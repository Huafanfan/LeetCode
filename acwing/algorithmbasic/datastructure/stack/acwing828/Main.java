package acwing.algorithmbasic.datastructure.stack.acwing828;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/3 4:27 PM
 */
public class Main {
    static int N = 100010;
    static int[] stk = new int[N];
    static int idx;

    static void push(int num){
        stk[++idx] = num;
    }

    static int pop(){
        return stk[idx--];
    }

    static String empty(){
        return idx > 0 ? "NO" : "YES";
    }

    static int query(){
        return stk[idx];
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
