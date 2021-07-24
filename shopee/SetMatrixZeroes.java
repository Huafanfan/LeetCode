package shopee;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/24 17:45
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean ifSetFirstRowZero = false;
        boolean ifSetFirstCloZero = false;
        if (matrix[0][0] == 0){
            ifSetFirstRowZero = true;
            ifSetFirstCloZero = true;
        }
        else {
            for (int i=1; i<matrix[0].length; i++){
                if (matrix[0][i] == 0){
                    ifSetFirstRowZero = true;
                    break;
                }
            }
            for (int i=1; i<matrix.length; i++){
                if (matrix[i][0] == 0){
                    ifSetFirstCloZero = true;
                    break;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++){
            for (int j=1; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i=1; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int i=1; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                for (int j=0; j<matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        if (ifSetFirstRowZero){
            Arrays.fill(matrix[0], 0);
        }
        if (ifSetFirstCloZero){
            for (int j=0; j<matrix.length; j++){
                matrix[j][0] = 0;
            }
        }
    }
}
