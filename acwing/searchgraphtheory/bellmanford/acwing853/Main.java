package acwing.searchgraphtheory.bellmanford.acwing853;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/24 4:58 PM
 */
public class Main {
    static int N = 510;
    static int M = 10010;
    static int n, m, k;
    static int[] dist;
    static int[] backup;
    static int INF = 0x3f3f3f3f;

    static class Edge {
        int a;
        int b;
        int w;
    }
    static Edge[] edges;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        dist = new int[n+1];
        backup = new int[n+1];
        edges = new Edge[m];

        for (int i=0; i<m; i++){
            edges[i] = new Edge();
            edges[i].a = in.nextInt();
            edges[i].b = in.nextInt();
            edges[i].w = in.nextInt();
        }

        bellManFold();
    }

    static void bellManFold(){
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for (int i=0; i<k; i++){
            System.arraycopy(dist, 0, backup, 0, n + 1);
            for (int j=0; j<m; j++){
                int a = edges[j].a;
                int b = edges[j].b;
                int w = edges[j].w;
                dist[b] = Math.min(dist[b], backup[a] + w);
            }
        }
        if(dist[n] > INF/2) {
            System.out.println("impossible");
        } else {
            System.out.println(dist[n]);
        }
    }
}
