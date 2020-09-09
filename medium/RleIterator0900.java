package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/9 16:09
 */
public class RleIterator0900 {
    private int[] A;
    private int index;
    private int q;
    public RleIterator0900(int[] A) {
        index = 0;
        q = 0;
        this.A = A;
    }

    public int next(int n) {
        while (index < A.length) {
            if (q + n > A[index]) {
                n -= A[index] - q;
                q = 0;
                index += 2;
            } else {
                q += n;
                return A[index+1];
            }
        }
        return -1;
    }
}
