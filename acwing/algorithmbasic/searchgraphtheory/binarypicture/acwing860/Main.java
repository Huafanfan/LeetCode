package acwing.algorithmbasic.searchgraphtheory.binarypicture.acwing860;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/25 4:28 PM
 */
public class Main {
    static int N = 100010, M = N * 2;
    static int n;
    static int m;
    static int[] h = new int[N];
    static int idx;
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static int[] color = new int[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();

        Arrays.fill(h, -1);

        while (m-- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            add(b, a);
        }

        boolean flag = true;
        for (int i=1; i<=n; i++){
            if (color[i] == 0){
                if (!dfs(i, 1)){
                    flag = false;
                    break;
                }
            }
        }
        if (flag){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static boolean dfs(int u, int c){
        color[u] = c;
        for (int index = h[u]; index != -1; index = ne[index]){
            int j = e[index];
            if (color[j] == 0){
                if (!dfs(j, 3 - c)){
                    return false;
                }
            } else if (color[j] == c){
                return false;
            }
        }
        return true;
    }

    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
