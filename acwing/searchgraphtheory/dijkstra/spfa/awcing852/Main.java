package acwing.searchgraphtheory.dijkstra.spfa.awcing852;

import java.io.BufferedInputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/24 6:17 PM
 */
public class Main {

    static int N = 1000010;
    static int n,m;
    static int[] h = new int[N];
    static int[] w = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int idx;
    static int[] dist = new int[N];
    static int[] cnt = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0){
            int a, b, c;
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            add(a, b, c);
        }

        if (spfa()){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static boolean spfa(){
        Deque<Integer> queue = new ArrayDeque<>();
        // 判断从任意起点开始的点是否有负环
        for (int i=1; i<=n; i++){
            st[i] = true;
            queue.addLast(i);
        }
        while (!queue.isEmpty()){
            int t = queue.pollFirst();
            st[t] = false;
            for (int index = h[t]; index != -1; index = ne[index]){
                int j = e[index];
                if (dist[j] > dist[t] + w[index]){
                    dist[j] = dist[t] + w[index];
                    cnt[j] = cnt[t] + 1;
                    if (cnt[j] >= n){
                        return true;
                    }
                    if (!st[j]){
                        queue.addLast(j);
                        st[j] = true;
                    }
                }
            }
        }
        return false;
    }

    static void add(int a, int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx;
        idx++;
    }
}
