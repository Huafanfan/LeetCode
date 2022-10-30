package acwing.algorithmbasic.searchgraphtheory.kruskal.acwing859;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/25 3:08 PM
 */
public class Main {
    static int N = 200010;
    static int n;
    static int m;
    static int[] p = new int[N];
    static Edge[] edges;

    static class Edge{
        int a;
        int b;
        int w;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        edges = new Edge[m];
        for (int i=0; i<m; i++){
            edges[i] = new Edge();
            edges[i].a = in.nextInt();
            edges[i].b = in.nextInt();
            edges[i].w = in.nextInt();
        }
        Arrays.sort(edges, Comparator.comparingInt(o -> o.w));

        for (int i=1; i<=n; i++){
            p[i] = i;
        }

        int res = 0;
        int cnt = 0;
        for (int i=0; i<m; i++){
            int a = edges[i].a;
            int b = edges[i].b;
            int w = edges[i].w;

            a = find(a);
            b = find(b);
            if (a != b){
                p[a] = b;
                res += w;
                cnt++;
            }
        }
        if (cnt != n-1){
            System.out.println("impossible");
        } else {
            System.out.println(res);
        }
    }
    static int find(int x){
        if (p[x] != x){
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
