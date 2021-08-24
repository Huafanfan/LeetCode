package medium;

import java.util.*;

public class CheapestFlightsWithinKStops0787 {
    int minCost = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        Map<Integer, List<Integer>> cost = new HashMap<>();
        for (int[] flight : flights) {
            edges.computeIfAbsent(flight[0], v -> new ArrayList<>()).add(flight[1]);
            cost.computeIfAbsent(flight[0], v -> new ArrayList<>()).add(flight[2]);
        }
        dfs(src, dst, k, edges, cost, 0);
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    public void dfs(int cur, int des, int k, Map<Integer, List<Integer>> edges, Map<Integer, List<Integer>> cost, int sumCost){
        if (cur == des){
            minCost = Math.min(minCost, sumCost);
            return;
        }
        if (k < 0){
            return;
        }
        for (int i=0; edges.containsKey(cur) && i<edges.get(cur).size(); i++){
            dfs(edges.get(cur).get(i), des, k-1, edges, cost, sumCost + cost.get(cur).get(i));
        }
    }

    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        // f[t][i] 表示通过恰好 t 次航班，从出发城市 src 到达城市 i 需要的最小花费
        int[][] f = new int[k + 2][n];
        for (int i = 0; i < k + 2; ++i) {
            Arrays.fill(f[i], INF);
        }
        f[0][src] = 0;
        for (int t = 1; t <= k + 1; ++t) {
            for (int[] flight : flights) {
                int i = flight[0], j = flight[1], cost = flight[2];
                f[t][j] = Math.min(f[t][j], f[t - 1][i] + cost);
            }
        }
        int ans = INF;
        for (int t = 1; t <= k + 1; ++t) {
            ans = Math.min(ans, f[t][dst]);
        }
        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) {
//        int[][] flights = new int[][]{{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
//        CheapestFlightsWithinKStops0787 cheapestFlightsWithinKStops0787 = new CheapestFlightsWithinKStops0787();
//        System.out.println(cheapestFlightsWithinKStops0787.findCheapestPrice(5, flights, 2 ,1, 1));
        int[][] flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        CheapestFlightsWithinKStops0787 cheapestFlightsWithinKStops0787 = new CheapestFlightsWithinKStops0787();
        System.out.println(cheapestFlightsWithinKStops0787.findCheapestPrice2(3, flights, 0 ,2, 1));
    }
}
