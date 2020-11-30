package easy;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/30 10:04
 */
public class LargestPerimeterTriangle0976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }
}
