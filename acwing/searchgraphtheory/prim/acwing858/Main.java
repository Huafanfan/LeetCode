package acwing.searchgraphtheory.prim.acwing858;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/25 12:24 PM
 */
public class Main {
    static int N = 510;
    static int n,m;
    static int[][] g= new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static int INF = 0x3f3f3f3f;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        for (int i=0; i<N; i++){
            Arrays.fill(g[i], INF);
        }

        while (m-- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }

        int t = prim();
        if (t == INF){
            System.out.println("impossible");
        } else {
            System.out.println(t);
        }
    }

    static int prim(){
        Arrays.fill(dist, INF);
        int res = 0;
        for (int i=0; i<n; i++){
            int t = -1;
            for (int j=1; j<=n; j++){
                if (!st[j] && (t == -1 || dist[t] > dist[j])){
                    t = j;
                }
            }

            if (i != 0 && dist[t] == INF){
                return INF;
            }

            if (i !=0){
                res += dist[t];
            }

            for (int j=1; j<=n; j++){
                dist[j] = Math.min(dist[j], g[t][j]);
            }

            st[t] = true;
        }
        return res;
    }
}
