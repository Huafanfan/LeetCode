package lcof;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/16 16:38
 */
public class Lcof29 {
    /**
     * 96.97%
     * 90.45%
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        int n = matrix.length;
        if (n < 1){
            return new int[0];
        }
        int m = matrix[0].length;
        int[] result = new int[n * m];
        int status = 0;
        int row = 0;
        int col = 0;
        int circle = 0;
        for (int i=0; i<result.length;){
            if (status == 0){
                while (col<m-circle){
                    result[i++] = matrix[row][col++];
                }
                col--;
                row++;
                status = 1;
            }
            else if (status == 1){
                while (row<n-circle){
                    result[i++] = matrix[row++][col];
                }
                row--;
                col--;
                status = 2;
            }
            else if (status == 2){
                while (col>=circle){
                    result[i++] = matrix[row][col--];
                }
                col++;
                row--;
                status = 3;
            }
            else {
                while (row>=1+circle){
                    result[i++] = matrix[row--][col];
                }
                row++;
                col++;
                status = 0;
                circle++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Lcof29 lcof29 = new Lcof29();
        System.out.println(Arrays.toString(lcof29.spiralOrder(matrix)));
    }
}
