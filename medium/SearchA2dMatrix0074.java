package medium;

public class SearchA2dMatrix0074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean isFind = false;
        int i=matrix.length-1;
        int j=0;
        while (i>=0 && j<matrix[0].length){
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
