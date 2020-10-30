package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/30 09:45
 */
public class IslandPerimeter0436 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]==1){
                    //if (i == 0){
                    //    result++;
                    //}
                    //if (i == grid.length-1){
                    //    result++;
                    //}
                    //if (j == 0){
                    //    result++;
                    //}
                    //if (j == grid[0].length-1){
                    //    result++;
                    //}
                    //if (i>0 && grid[i-1][j]==0){
                    //    result++;
                    //}
                    //if (i<grid.length-1 && grid[i+1][j]==0){
                    //    result++;
                    //}
                    //if (j>0 && grid[i][j-1]==0){
                    //    result++;
                    //}
                    //if (j<grid[0].length-1 && grid[i][j+1]==0){
                    //    result++;
                    //}
                    //优化
                    int cnt = 0;
                    for (int k = 0; k < 4; ++k) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if (tx < 0 || tx >= grid.length || ty < 0 || ty >= grid[0].length || grid[tx][ty] == 0) {
                            cnt += 1;
                        }
                    }
                    result += cnt;
                }
            }
        }
        return result;
    }

    public int islandPerimeterdfs(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (grid[i][j] == 1){
                    ans += dfs(i,j,grid,n,m);
                }
            }
        }
        return ans;
    }

    public int dfs(int i, int j, int[][] grid, int n, int m){
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0){
            return 1;
        }
        if (grid[i][j]==2){
            return 0;
        }
        grid[i][j] = 2;
        int res = 0;
        for (int k = 0; k < 4; ++k) {
            int tx = i + dx[k];
            int ty = j + dy[k];
            res += dfs(tx, ty, grid, n, m);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        IslandPerimeter0436 islandPerimeter0436 = new IslandPerimeter0436();
        System.out.println(islandPerimeter0436.islandPerimeter(grid));
    }
}
