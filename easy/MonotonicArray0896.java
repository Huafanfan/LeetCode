package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/28 10:44
 */
public class MonotonicArray0896 {
    public boolean isMonotonic(int[] A) {
        int len = A.length;
        if (len < 2){
            return true;
        }
        int index = 1;
        while (index < len && A[index] == A[index-1]){
            index++;
        }
        if (index == len){
            return true;
        }
        boolean isUp = A[index] > A[index - 1];
        while (index < len){
            if (A[index] != A[index - 1] && (A[index] > A[index - 1] != isUp)){
                return false;
            }
            index++;
        }
        return true;
    }

    public boolean isMonotonic2(int[] A) {
        boolean inc = true, dec = true;
        int n = A.length;
        for (int i = 0; i < n - 1; ++i) {
            if (A[i] > A[i + 1]) {
                inc = false;
            }
            if (A[i] < A[i + 1]) {
                dec = false;
            }
        }
        return inc || dec;
    }
}
