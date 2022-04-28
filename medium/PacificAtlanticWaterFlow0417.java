package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/4/28 11:00
 */
public class PacificAtlanticWaterFlow0417 {
    static int[][] dirs = {{-1, 0},{1, 0},{0, 1},{0, -1}};
    int[][] heights;
    int m,n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i=0; i<m; i++){
            dfs(i, 0, pacific);
        }
        for (int j=1; j<n; j++){
            dfs(0, j, pacific);
        }
        for (int i=0; i<m; i++){
            dfs(i, n-1, atlantic);
        }
        for (int j=0; j<n; j++){
            dfs(m-1, j, atlantic);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<Integer>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    public void dfs(int row, int clo, boolean[][] ocean){
        if (ocean[row][clo]){
            return;
        }
        ocean[row][clo] = true;
        for (int[] dir : dirs){
            int newRow = row + dir[0];
            int newClo = clo + dir[1];
            if (newRow >= 0 && newRow < m && newClo >=0 && newClo < n && heights[newRow][newClo] >= heights[m][n]){
                dfs(newRow, newClo, ocean);
            }
        }
    }
}
