package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/10 14:43
 */
public class SpiralMatrix0054 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int sum = matrix.length * matrix[0].length;
        while (res.size() != sum) {
            for (int i=left; i<=right && res.size() != sum; i++){
                res.add(matrix[up][i]);
            }
            up++;
            for (int i=up; i<=down && res.size() != sum; i++){
                res.add(matrix[i][right]);
            }
            right--;
            for (int i=right; i>=left && res.size() != sum; i--){
                res.add(matrix[down][i]);
            }
            down--;
            for (int i=down; i>=up && res.size() != sum; i--){
                res.add(matrix[i][left]);
            }
            left++;

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        SpiralMatrix0054 spiralMatrix0054 = new SpiralMatrix0054();
        System.out.println(spiralMatrix0054.spiralOrder(matrix));
    }
}
