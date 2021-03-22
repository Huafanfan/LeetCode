package lcof;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/12 15:19
 */
public class Lcof13 {
    int result;

    /**
     * 85.52%
     * 81.89%
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] isMeet = new boolean[m][n];
        dfs(0, 0, m, n, k, isMeet);
        return result;
    }

    public void dfs(int i, int j, int m, int n, int k ,boolean[][] isMeet) {
        if (i>=0 && i<m && j>=0 && j<n && isVerify(i,j,k) && !isMeet[i][j]){
            result++;
            isMeet[i][j] = true;
            dfs(i+1, j, m, n, k, isMeet);
            dfs(i, j+1, m, n, k, isMeet);
        }
    }

    public boolean isVerify(int i, int j, int k) {
        int result = 0;
        while (i!=0||j!=0){
            result += i % 10;
            i /= 10;
            result += j % 10;
            j /= 10;
        }
        return result <= k;
    }

    /**
     * 22.77%
     * 27.17%
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount2(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

}
