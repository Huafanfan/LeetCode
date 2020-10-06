package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/6 09:10
 */
public class SumofDistancesinTree0834 {
    /**
     * 探索从根节点出发到各个子节点的路径和
     * @param N
     * @param edges
     * @return
     */
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[] result = new int[N];
        int[][] distance = new int[N][N];
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int[] edge : edges) {
            distance[edge[0]][edge[1]] = 1;
            distance[edge[1]][edge[0]] = 1;
        }
        Recursion(N, distance, result, 0);
        return result;
    }

    public int Recursion(int N, int[][] distance, int[] result, int root){
        for (int i=root+1; i<N; i++){
            if (distance[root][i] == 1){
                result[root] += Recursion(N, distance, result, i) + SZ(distance, i, N);
            }
        }
        return result[root];
    }
    public int SZ(int[][] distance, int node, int N){
        int result = 0;
        for (int i=node+1; i<N; i++){
            if (distance[node][i]==1){
                result++;
            }
        }
        return result + 1;
    }

    int[] ans;
    //sz[u] 表示以u为根的子树的节点数量
    int[] sz;
    //dp[u] 表示以 u为根的子树，它的所有子节点到它的距离之和
    int[] dp;
    List<List<Integer>> graph;
    public int[] sumOfDistancesInTree2(int N, int[][] edges) {
        ans = new int[N];
        sz = new int[N];
        dp = new int[N];
        graph = new ArrayList<>();
        for (int i=0; i<N; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, -1);
        dfs2(0,-1);
        return ans;
    }

    /**
     *
     * @param u 当前节点
     * @param f 父节点
     */
    public void dfs(int u, int f){
        sz[u] = 1;
        dp[u] = 0;
        for (int v : graph.get(u)){
            if (v == f){
                continue;
            }
            dfs(v,u);
            dp[u] += dp[v] + sz[v];
            sz[u] += sz[v];
        }
    }

    public void dfs2(int u, int f){
        ans[u] = dp[u];
        for (int v : graph.get(u)){
            if (v == f){
                continue;
            }
            int pu = dp[u], pv = dp[v];
            int su = sz[u], sv = sz[v];

            dp[u] -= dp[v] + sz[v];
            sz[u] -= sz[v];
            dp[v] += dp[u] + sz[u];
            sz[v] += sz[u];

            dfs2(v, u);

            dp[u] = pu;
            dp[v] = pv;
            sz[u] = su;
            sz[v] = sv;
        }
    }

    public static void main(String[] args) {
        SumofDistancesinTree0834 sumofDistancesinTree0834 = new SumofDistancesinTree0834();
        int[][] edges = new int[][]{{0,1},{0,2},{0,3},{1,4},{1,5},{1,6},{2,7}};
        System.out.println(Arrays.toString(sumofDistancesinTree0834.sumOfDistancesInTree2(8, edges)));
    }
}
