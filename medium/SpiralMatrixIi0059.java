package medium;

import java.util.Arrays;

public class SpiralMatrixIi0059 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int index = 1;
        while (index <= n * n) {
            for (int i=left; i<=right; i++){
                res[up][i] = index++;
            }
            up++;
            for (int i=up; i<=down; i++){
                res[i][right] = index++;
            }
            right--;
            for (int i=right; i>=left; i--){
                res[down][i] = index++;
            }
            down--;
            for (int i=down; i>=up; i--){
                res[i][left] = index++;
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrixIi0059 spiralMatrixIi0059 = new SpiralMatrixIi0059();
        System.out.println(Arrays.deepToString(spiralMatrixIi0059.generateMatrix(3)));
    }
}
