package easy;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/16 09:32
 */
public class SquaresofASortedArray0977 {
    public int[] sortedSquares1(int[] A) {
        int[] result = new int[A.length];
        for (int i=0; i<A.length; i++){
            result[i] = A[i] * A[i];
        }
        Arrays.sort(result);
        return result;
    }
    public int[] sortedSquares2(int[] A) {
        int[] result = new int[A.length];
        for (int i = 0, j = A.length-1, pos = A.length-1; pos >= 0; pos--){
            if (A[i] * A[i] > A[j] * A[j]){
                result[pos] = A[i] * A[i];
                i++;
            }else {
                result[pos] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SquaresofASortedArray0977 squaresofASortedArray0977 = new SquaresofASortedArray0977();
        int[] A = new int[]{-7,-3,2,3,11};
        System.out.println(Arrays.toString(squaresofASortedArray0977.sortedSquares2(A)));
    }
}
