package easy;

import java.util.Arrays;

/**
 * @author yifan.zhangyf
 * @date 2022/9/4 2:55 PM
 */
public class SpecialPositionsInABinaryMatrix1582 {
    public int numSpecial(int[][] mat) {
        int[] rows = new int[mat.length];
        int[] clos = new int[mat[0].length];
        for (int i=0; i<mat.length; i++){
            rows[i] = Arrays.stream(mat[i]).sum();
        }
        for (int i=0; i<mat[0].length; i++){
            int sum = 0;
            for (int[] ints : mat) {
                sum += ints[i];
            }
            clos[i] = sum;
        }
        int count = 0;
        for (int i=0; i<mat.length; i++){
            for (int j=0; j<mat[0].length; j++){
                if (mat[i][j] == 1 && rows[i] == 1 && clos[j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}
