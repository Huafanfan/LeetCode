package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/20 16:53
 */
public class Searcha2dMatrixii0240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int diagonal = Math.min(matrix.length, matrix[0].length);
        for (int i=0; i<diagonal; i++){
            if (matrix[i][i]==target){
                return true;
            }
            else {
                //水平
                Boolean horizontal = BinarySearch(matrix,i,target,false);
                //垂直
                Boolean vertical = BinarySearch(matrix,i,target,true);
                if (horizontal||vertical){
                    return true;
                }
            }
        }
        return false;
    }
    Boolean BinarySearch(int[][] matrix,int start,int target,boolean isVertical){
        int left = start+1;
        int right = isVertical ?matrix[0].length-1:matrix.length-1;
        while (left<=right){
            int mid = (left+right)>>2;
            if (isVertical){
                if (matrix[mid][start]<target){
                    left = mid + 1;
                }else if (matrix[mid][start]>target){
                    right = mid - 1;
                }
                else {
                    return true;
                }
            }
            else {
                if (matrix[start][mid]<target){
                    left = mid + 1;
                }else if (matrix[start][mid]>target){
                    right = mid - 1;
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrixPro(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int startRow = row - 1;
        int startCol = 0;
        while (startRow<row&&startRow>=0&&startCol<col){
            if (matrix[startRow][startCol]<target){
                startCol++;
            }else if (matrix[startRow][startCol]>target){
                startRow--;
            }else {
                return true;
            }
        }
        return false;
    }
}
