package hard;

import java.util.*;

public class BusRoutes0815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target){
            return 0;
        }
        int n = routes.length;
        boolean[][] edge = new boolean[n][n];
        Map<Integer, List<Integer>> rec = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> list = rec.getOrDefault(site, new ArrayList<>());
                for (int j : list) {
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);
                rec.put(site, list);
            }
        }

        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        Queue<Integer> que = new LinkedList<Integer>();
        for (int site : rec.getOrDefault(source, new ArrayList<Integer>())) {
            dis[site] = 1;
            que.offer(site);
        }
        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y = 0; y < n; y++) {
                if (edge[x][y] && dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    que.offer(y);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int site : rec.getOrDefault(target, new ArrayList<Integer>())) {
            if (dis[site] != -1) {
                ret = Math.min(ret, dis[site]);
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}
