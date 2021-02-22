package easy;

public class ToeplitzMatrix0766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0; i<n; i++){
            int template = matrix[0][i];
            int j = 0, k = i;
            while (j < m && k < n){
                if (matrix[j][k] == template){
                    j++;
                    k++;
                }
                else {
                    return false;
                }
            }
        }

        for (int i=1; i<m; i++){
            int template = matrix[i][0];
            int j = i, k = 0;
            while (j < m && k < n){
                if (matrix[j][k] == template){
                    j++;
                    k++;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isToeplitzMatrix2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;

    }
}
