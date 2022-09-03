package acwing.datastructure.singlelist.acwing826;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/8/31 10:13 PM
 */
public class Main {
    static int N = 100010;
    static int head;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int idx;

    static void init(){

        head = -1;
        idx = 0;
    }

    static void addToHead(int x){
        e[idx] = x;

        ne[idx] = head;
        head = idx;
        idx++;
    }

    static void add(int k, int x){
        e[idx] = x;

        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }

    static void delete(int k){
        ne[k] = ne[ne[k]];
    }

    public static void main(String[] args) {
        init();

        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int m = in.nextInt();

        while (m-- > 0){
            String cmd = in.next();
            int k ,x;
            switch (cmd){
                case "H":
                    x = in.nextInt();
                    addToHead(x);
                    break;
                case "D":
                    k = in.nextInt();
                    if (k == 0){
                        head = ne[head];
                    } else {
                        delete(k-1);
                    }
                    break;
                default:
                    k = in.nextInt();
                    x = in.nextInt();
                    add(k-1, x);
                    break;
            }
        }
        for (int i=head; i!=-1; i = ne[i]){
            System.out.print(e[i] + " ");
        }

    }
}
