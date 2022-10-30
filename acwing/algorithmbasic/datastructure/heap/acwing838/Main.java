package acwing.algorithmbasic.datastructure.heap.acwing838;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/11 5:54 PM
 */
public class Main {
    static int N = 100010;
    static int[] h = new int[N];
    /**
     * ph[k] : 第k个插入点的下标
     */
    static int[] ph = new int[N];
    /**
     * 堆里面的某个点是第几个插入点
     */
    static int[] hp = new int[N];
    static int size;
    public static void main(String[] args) {
        int index = 0;
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        while (n-- > 0){
            int k,x;
            String cmd = in.next();
            if ("I".equals(cmd)){
                x = in.nextInt();
                size++;
                index++;
                ph[index] = size;
                hp[size] = index;
                h[size] = x;
                up(size);
            } else if ("PM".equals(cmd)){
                System.out.println(h[1]);
            } else if ("DM".equals(cmd)){
                headSwap(1, size);
                size--;
                down(1);
            } else if ("D".equals(cmd)){
                k = in.nextInt();
                k = ph[k];
                headSwap(k, size);
                size--;
                down(k);
                up(k);
            } else {
                k = in.nextInt();
                x = in.nextInt();
                k = ph[k];
                h[k] = x;
                down(k);
                up(k);
            }
        }
    }
    static void down(int u){
        int t = u;
        if (u * 2 <= size && h[u * 2] < h[t]){
            t = u * 2;
        }
        if (u * 2 + 1 <= size && h[u * 2 + 1] < h[t]){
            t = u * 2 + 1;
        }
        if (u != t){
            headSwap(u, t);
            down(t);
        }
    }

    static void up(int u){
        while (u/2 != 0 && h[u/2] > h[u]){
            headSwap(u, u/2);
            u /= 2;
        }
    }

    static void headSwap(int a, int b){
        int tmp = ph[hp[a]];
        ph[hp[a]] = ph[hp[b]];
        ph[hp[b]] = tmp;

        tmp = hp[a];
        hp[a] = hp[b];
        hp[b] = tmp;

        tmp = h[a];
        h[a] = h[b];
        h[b] = tmp;
    }
}
