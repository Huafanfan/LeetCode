package neetcode.binarysearch;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/10 10:43
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int clo = 0;
        while (row >=0 && clo < matrix[0].length){
            if (matrix[row][clo] == target){
                return true;
            } else if (matrix[row][clo] < target){
                clo++;
            } else {
                row--;
            }
        }
        return false;
    }
}
