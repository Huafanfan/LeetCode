package hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/9 10:18
 */
public class SubarraysWithKDifferentIntegers0992 {

    public int subarraysWithKDistinct(int[] A, int K) {
        return maxArraysWithKDistinct(A, K) - maxArraysWithKDistinct(A, K-1);
    }

    public int maxArraysWithKDistinct(int[] A, int K){
        int res = 0;
        int len = A.length;
        int[] frequency = new int[len];
        int count = 0;
        int left = 0;
        int right = 0;
        while (right<len){
            if (frequency[A[right]] == 0){
                count++;
            }
            frequency[A[right]]++;
            right++;
            while (count > K){
                frequency[A[left]]--;
                if (frequency[A[left]] == 0){
                    count--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }

    public static void main(String[] args) {
        SubarraysWithKDifferentIntegers0992 subarraysWithKDifferentIntegers0992 = new SubarraysWithKDifferentIntegers0992();
        int[] A = new int[]{2,1,2,1,2};
        System.out.println(subarraysWithKDifferentIntegers0992.subarraysWithKDistinct(A, 2));
    }
}
