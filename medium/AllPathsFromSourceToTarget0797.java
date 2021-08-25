package medium;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget0797 {
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, graph.length - 1, graph, path);
        return res;
    }

    public void dfs(int cur, int end, int[][] graph, List<Integer> path){
        if (cur == end){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[cur]){
            path.add(next);
            dfs(next, end, graph, path);
            path.remove(path.size() - 1);
        }
    }
}
