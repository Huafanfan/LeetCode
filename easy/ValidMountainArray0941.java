package easy;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/3 09:30
 */
public class ValidMountainArray0941 {
    class Solution {
        public boolean validMountainArray(int[] A) {
            boolean up = true;
            if (A.length<2){
                return false;
            }
            if (A[1] <= A[0]){
                return false;
            }
            for (int i=2; i<A.length; i++){
                if (up){
                    if (A[i] == A[i-1]){
                        return false;
                    }
                    else if (A[i] < A[i-1]){
                        up = false;
                    }
                }
                else {
                    if (A[i]>= A[i-1]){
                        return false;
                    }
                }
            }
            return !up;
        }
    }
}
