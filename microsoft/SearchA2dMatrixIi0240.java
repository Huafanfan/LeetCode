package microsoft;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/14 16:08
 */
public class SearchA2dMatrixIi0240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = row-1, j = 0;
        while (i >= 0 && i != row && j >= 0 && j != col) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
