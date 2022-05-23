package hard;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/23 10:46
 */
public class CutOffTreesForGolfEvent0675 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        int row = forest.size();
        int col = forest.get(0).size();
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (forest.get(i).get(j) > 1){
                    trees.add(new int[]{i, j});
                }
            }
        }
        trees.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return forest.get(o1[0]).get(o1[1]) - forest.get(o2[0]).get(o2[1]);
            }
        });
        int cx = 0, cy = 0;
        int res = 0;
        for (int[] tree : trees) {
            int step = bfs(forest, cx, cy, tree[0], tree[1]);
            if (step == -1) {
                return -1;
            }
            res += step;
            cx = tree[0];
            cy = tree[1];
        }
        return res;
    }
    public int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return 0;
        }
        int row = forest.size();
        int col = forest.get(0).size();
        int step = 0;
        Deque<int[]> queue = new ArrayDeque<int[]>();
        boolean[][] visited = new boolean[row][col];
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        while (!queue.isEmpty()) {
            step++;
            int sz = queue.size();
            for (int i = 0; i < sz; ++i) {
                int[] cell = queue.poll();
                int cx = cell[0], cy = cell[1];
                for (int j = 0; j < 4; ++j) {
                    int nx = cx + dirs[j][0];
                    int ny = cy + dirs[j][1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                        if (!visited[nx][ny] && forest.get(nx).get(ny) > 0) {
                            if (nx == tx && ny == ty) {
                                return step;
                            }
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    // A*
    public int bfs2(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return 0;
        }

        int row = forest.size();
        int col = forest.get(0).size();
        int[][] costed = new int[row][col];
        for (int i = 0; i < row; ++i) {
            Arrays.fill(costed[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        costed[sx][sy] = Math.abs(sx - tx) + Math.abs(sy - ty);
        pq.offer(new int[]{costed[sx][sy], 0, sx * col + sy});
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int cost = arr[0], dist = arr[1], loc = arr[2];
            int cx = loc / col;
            int cy = loc % col;
            if (cx == tx && cy == ty) {
                return dist;
            }
            for (int i = 0; i < 4; ++i) {
                int nx = cx + dirs[i][0];
                int ny = cy + dirs[i][1];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && forest.get(nx).get(ny) > 0) {
                    int ncost = dist + 1 + Math.abs(nx - tx) + Math.abs(ny - ty);
                    if (ncost < costed[nx][ny]) {
                        pq.offer(new int[]{ncost, dist + 1, nx * col + ny});
                        costed[nx][ny] = ncost;
                    }
                }
            }
        }
        return -1;
    }
}
