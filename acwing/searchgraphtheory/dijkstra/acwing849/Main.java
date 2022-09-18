package acwing.searchgraphtheory.dijkstra.acwing849;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/9/18 12:05 PM
 */
public class Main {

    static int N = 510;
    static int n,m;
    static int[][] g= new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        for (int i=1; i<=n; i++){
            Arrays.fill(g[i], 0x3f3f);
        }
        while (m-- > 0){
            int a, b, c;
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            g[a][b] = Math.min(g[a][b], c);
        }

        System.out.println(dijkstra());
    }

    static int dijkstra(){
        Arrays.fill(dist, 0x3f3f);
        dist[1] = 0;
        for (int i=0; i<n; i++){
            int t = -1;
            for (int j=1; j<=n; j++){
                if (!st[j] && (t == -1 || dist[t] > dist[j])){
                    t = j;
                }
            }
            st[t] = true;
            /**
             * 下面的操作的时间复杂是m，因为用的邻接矩阵，所以代码看是n^2，但是使用邻接表的话，
             * 就是选出来的t这个节点所有关联的边更新一下，所有加起来就是m
             */
            for (int j=1; j<=n; j++){
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }
        return dist[n] == 0x3f3f ? -1 : dist[n];
    }
}
