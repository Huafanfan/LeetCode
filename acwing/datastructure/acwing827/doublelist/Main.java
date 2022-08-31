package acwing.datastructure.acwing827.doublelist;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/8/31 11:29 PM
 */
public class Main {
    static int N = 100010;
    static int[] e = new int[N];
    static int[] l = new int[N];
    static int[] r = new int[N];
    static int idx;

    static void init(){
        // 0 表示头结点， 1 表示尾节点
        r[0] = 1;
        l[1] = 0;
        idx = 2;
    }

    /**
     * k 的右边加入一个点
     */
    static void add(int k ,int x){
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx;
        idx++;
    }

    /**
     * 删除 k 的右边的一个点
     */
    static void delete(int k){
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }

//    static void add_left(int x){
//        e[idx] = x;
//        r[idx] = r[0];
//        l[idx] = 0;
//        l[r[0]] = idx;
//        r[0] = idx;
//    }

    public static void main(String[] args) {
        init();

        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int m = in.nextInt();

        while (m-- > 0){
            String cmd = in.next();
            int k ,x;
            switch (cmd){
                case "L":
                    x = in.nextInt();
                    add(0, x);
                    break;
                case "R":
                    x = in.nextInt();
                    add(l[1], x);
                    break;
                case "D":
                    k = in.nextInt();
                    delete(k - 1 + 2);
                    break;
                case "IL":
                    k = in.nextInt();
                    x = in.nextInt();
                    add(l[k - 1 + 2], x);
                    break;
                default:
                    k = in.nextInt();
                    x = in.nextInt();
                    add(k - 1 + 2, x);
                    break;
            }
        }
        for (int i=r[0]; i!=1; i = r[i]){
            System.out.print(e[i] + " ");
        }
    }
}
