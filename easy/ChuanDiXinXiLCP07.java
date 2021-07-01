package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ChuanDiXinXiLCP07 {
    int way = 0;
    public int numWays(int n, int[][] relation, int k) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i=0; i<n; i++){
            edges.add(new ArrayList<>());
        }
        for (int[] edge : relation){
            edges.get(edge[0]).add(edge[1]);
        }
        dfs(0, 0, k, edges);
        return way;
    }

    public void dfs(int index, int step, int k, List<List<Integer>> edges){
        if (step == k){
            if (index == edges.size() - 1){
                way++;
            }
            return;
        }
        List<Integer> edge = edges.get(index);
        for (int nextIndex : edge){
            dfs(nextIndex, step + 1, k, edges);
        }
    }

    public int numWays2(int n, int[][] relation, int k) {
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            edges.get(src).add(dst);
        }

        int steps = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while (!queue.isEmpty() && steps < k) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                List<Integer> list = edges.get(index);
                for (int nextIndex : list) {
                    queue.offer(nextIndex);
                }
            }
        }

        int ways = 0;
        if (steps == k) {
            while (!queue.isEmpty()) {
                if (queue.poll() == n - 1) {
                    ways++;
                }
            }
        }
        return ways;
    }

    public int numWays3(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }
}
