package acwing.searchgraphtheory.spfa.acwing851;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @author yifan.zhangyf
 * @date 2022/9/24 5:38 PM
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

        int t = spfa();

        if (t == 0x3f3f3f3f){
            System.out.println("impossible");
        } else {
            System.out.println(t);
        }
    }

    static int spfa(){
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        st[1] = true;
        while (!queue.isEmpty()){
            int t = queue.pollFirst();
            st[t] = false;
            for (int index = h[t]; index != -1; index = ne[index]){
                int j = e[index];
                if (dist[j] > dist[t] + w[index]){
                    dist[j] = dist[t] + w[index];
                    if (!st[j]){
                        queue.addLast(j);
                        st[j] = true;
                    }
                }
            }
        }
        return dist[n];
    }

    static void add(int a, int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx;
        idx++;
    }
}
