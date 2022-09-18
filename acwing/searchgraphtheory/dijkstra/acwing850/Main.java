package acwing.searchgraphtheory.dijkstra.acwing850;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @author yifan.zhangyf
 * @date 2022/9/18 12:06 PM
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

        System.out.println(dijkstra());
    }

    static int dijkstra(){
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        queue.add(new int[]{0, 1});
        while (!queue.isEmpty()){
            int[] t = queue.poll();

            int distance = t[0];
            int ver = t[1];
            if (st[ver]){
                continue;
            }
            st[ver] = true;
            for (int index = h[ver]; index != -1; index = ne[index]){
                int j = e[index];
                if (dist[j] > distance + w[index]){
                    dist[j] = distance + w[index];
                    queue.add(new int[]{dist[j], j});
                }
            }
        }

        return dist[n] == 0x3f3f3f3f ? -1 : dist[n];
    }

    static void add(int a, int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx;
        idx++;
    }
}
