package medium;

import sun.jvm.hotspot.memory.Space;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/25 09:32
 */
public class LongestMountaininArray0845 {
    public int longestMountain(int[] A) {
        int result = 0;
        for (int i=0; i<A.length; i++){
            int countUp = 0;
            int countDown = 0;
            int start = i;
            for (; start < A.length - 1; start++){
                if (A[start + 1] > A[start]){
                    countUp++;
                }
                else {
                    break;
                }
            }
            for (; start < A.length - 1; start++){
                if (A[start + 1] < A[start]){
                    countDown++;
                }
                else {
                    break;
                }
            }
            if (countUp > 0 && countDown > 0){
                result = Math.max(result, countUp + countDown);
            }
        }
        return result == 0 ? 0 : ++result;
    }

    public int longestMountainMountainTop(int[] A) {
        int n = A.length;
        if (n == 0){
            return 0;
        }
        int[] left = new int[n];
        for (int i=1; i<n; i++){
            left[i] = A[i] > A[i-1] ? left[i-1] + 1 : 0;
        }
        int[] right = new int[n];
        for (int j=n-2; j>=0; j--){
            right[j] = A[j] > A[j+1] ? right[j+1] + 1: 0;
        }
        int result = 0;
        for (int i=0; i<n; i++){
            if (left[i]>0 && right[i]>0){
                result = Math.max(result, left[i] + right[i] + 1);
            }
        }
        return result;
    }

    public int longestMountainMountainFoot(int[] A) {
        int n = A.length;
        int ans = 0;
        int left = 0;
        while (left + 2 < n){
            int right = left + 1;
            if (A[left] < A[left + 1]){
                while (right + 1 < n && A[right] < A[right+1]){
                    right++;
                }
                if (right < n - 1 && A[right] > A[right+1]){
                    while (right + 1 < n && A[right] > A[right + 1]){
                        right ++;
                    }
                    ans = Math.max(ans, right - left + 1);
                }else {
                    right++;
                }
            }
            left = right;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4,5};
        LongestMountaininArray0845 longestMountaininArray0845 = new LongestMountaininArray0845();
        System.out.println(longestMountaininArray0845.longestMountain(A));
    }
}
