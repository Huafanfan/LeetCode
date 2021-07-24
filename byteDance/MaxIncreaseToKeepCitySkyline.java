package byteDance;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/24 15:48
 */
public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] topMost = new int[n];
        int[] leftMost = new int[n];
        for (int i=0; i<n; i++){
            int max = 0;
            for (int[] ints : grid) {
                max = Math.max(max, ints[i]);
            }
            topMost[i] = max;
        }
        for (int i=0; i<n; i++){
            int max = 0;
            for (int j=0; j<n; j++) {
                max = Math.max(max, grid[i][j]);
            }
            leftMost[i] = max;
        }
        int res = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                res += Math.min(topMost[j], leftMost[i]) - grid[i][j];
            }
        }
        return res;
    }
}
