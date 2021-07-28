package byteDance;

import java.util.HashSet;
import java.util.Set;

public class IsGraphBipartite {
    int[] color;
    boolean ifFind = true;
    public boolean isBipartite(int[][] graph) {
        // 0为为染色，1为红，2为绿
        color = new int[graph.length];
        for (int i=0; i<graph.length && ifFind; i++){
            if (color[i] == 0){
                color[i] = 1;
                dfs(graph, i);
            }
        }
        dfs(graph,0);
        return ifFind;
    }

    public void dfs(int[][] graph, int index){
        if (!ifFind){
            return;
        }
        for (int i=0; i<graph[index].length; i++){
            if (color[graph[index][i]] == 0){
                color[graph[index][i]] = color[index] == 1 ? 2 : 1;
                dfs(graph, graph[index][i]);
            }
            else {
                if (color[graph[index][i]] == color[index]){
                    ifFind = false;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        IsGraphBipartite isGraphBipartite = new IsGraphBipartite();
        //[[1],[0,3],[3],[1,2]]
        int[][] graph = new int[][]{{1},{0,3},{3},{1,2}};
        System.out.println("isGraphBipartite.isBipartite(graph) = " + isGraphBipartite.isBipartite(graph));
    }
}
