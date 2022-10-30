package acwing.algorithmbasic.searchgraphtheory.hungary.acwing861;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/25 4:29 PM
 */
public class Main {
    static int N = 510, M = 100010;
    static int n1;
    static int n2;
    static int m;
    static int[] h = new int[N];
    static int idx;
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int[] match = new int[N];
    static boolean[] st = new boolean[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n1 = in.nextInt();
        n2 = in.nextInt();
        m = in.nextInt();

        Arrays.fill(h, -1);

        while (m-- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
        }

        int res = 0;
        for (int i=1; i<= n1; i++){
            Arrays.fill(st, false);
            if (find(i)){
                res++;
            }
        }
        System.out.println(res);
    }

    static boolean find(int x){
        for (int index = h[x]; index != -1; index = ne[index]){
            int j = e[index];
            if (!st[j]){
                st[j] = true;
                // 因为st[j] = true, 所以当前j的匹配回去寻找其他非j的配对
                if (match[j] == 0 || find(match[j])){
                    match[j] = x;
                    return true;
                }
            }
        }
        return false;
    }

    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
