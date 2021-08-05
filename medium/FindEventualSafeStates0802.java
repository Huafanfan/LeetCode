package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FindEventualSafeStates0802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<n; i++){
            if (dfs(graph, color, i)){
                res.add(i);
            }
        }
        return res;
    }
    public boolean dfs(int[][] graph, int[] color, int cur){
        if (color[cur] > 0){
            return color[cur] == 2;
        }
        color[cur] = 1;
        for (int next : graph[cur]){
            if (!dfs(graph, color, next)){
                return false;
            }
        }
        color[cur] = 2;
        return true;
    }

    public List<Integer> eventualSafeNodes2(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> rg = new ArrayList<>();
        for (int i=0; i<n; i++){
            rg.add(new ArrayList<>());
        }
        int[] inDeg = new int[n];
        for (int i=0; i<n; i++){
            for (int j : graph[i]){
                rg.get(j).add(i);
            }
            inDeg[i] = graph[i].length;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i=0; i<n; i++){
            if (inDeg[i] == 0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int j = queue.poll();
            for (int i : rg.get(j)){
                if (--inDeg[i] == 0){
                    queue.add(i);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<n; i++){
            if (inDeg[i] == 0){
                res.add(i);
            }
        }
        return res;
    }
}
