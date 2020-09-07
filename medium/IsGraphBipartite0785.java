package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/7 12:05
 */
public class IsGraphBipartite0785 {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1},{0,3},{3},{1,2}};
        IsGraphBipartite0785 isGraphBipartite0785 = new IsGraphBipartite0785();
        //System.out.println(isGraphBipartite0785.isBipartite(graph));
    }
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;

    public boolean isBipartiteDFS(int[][] graph) {
        int n = graph.length;
        color = new int[graph.length];
        valid = true;
        Arrays.fill(color,UNCOLORED);
        for (int i=0; i<n&&valid; i++){
            if (color[i]==UNCOLORED){
                dfs(i,RED,graph);
            }
        }
        return valid;
    }

    public void dfs(int node, int c, int[][] graph){
        color[node] = c;
        int exColor = c == RED ? GREEN : RED;
        for (int neighbor : graph[node]){
            if (color[neighbor]==UNCOLORED){
                dfs(neighbor,exColor,graph);
                if (!valid){
                    return;
                }
            }else if(color[neighbor] != exColor){
                valid = false;
                return;
            }
        }
    }

    public boolean isBipartiteBFS(int[][] graph) {
        int n = graph.length;
        color = new int[graph.length];
        Arrays.fill(color,UNCOLORED);
        for (int i=0; i<n; i++){
            if (color[i]==UNCOLORED){
                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(i);
                color[i] = RED;
                while (!queue.isEmpty()){
                    int node = queue.poll();
                    int exColor = color[node] == RED ? GREEN : RED;
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == UNCOLORED) {
                            queue.add(neighbor);
                            color[neighbor] = exColor;
                        } else if (color[neighbor] != exColor) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
