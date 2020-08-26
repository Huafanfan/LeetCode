package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/26 14:13
 */
public class KthSmallestElementinaSortedMatrix0378 {
    /**
     * 二分查找
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n-1][n-1];
        while (min < max){
            int mid = (min + max)/2;
            if (check(matrix, mid, k, n)){
                max = mid;
            }else {
                min = mid + 1;
            }
        }
        return min;
    }
    public boolean check(int[][] matrix, int mid, int k, int n){
        int i = n-1;
        int j = 0;
        int count = 0;
        while (i>=0 && j<n){
            if (matrix[i][j] <= mid){
                count += i+1;
                j++;
            }else {
                i--;
            }
        }
        return count>=k;
    }
}
