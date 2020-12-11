package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/11 14:47
 */
public class Lcof04 {
    /**
     * 100.00%
     * 69.79%
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean isFind = false;
        int i=matrix.length-1;
        int j=0;
        while (i>=0 || j<matrix[0].length){
            if (matrix[i][j] == target){
                isFind = true;
                break;
            }
            else if (matrix[i][j] < target){
                j++;
            }
            else {
                i--;
            }
        }
        return isFind;
    }
}
