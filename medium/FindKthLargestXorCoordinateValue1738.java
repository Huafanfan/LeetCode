package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/19 09:43
 */
public class FindKthLargestXorCoordinateValue1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        int[] xors = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                if (i==0 && j==0){
                    xors[index++] = matrix[i][j];
                    continue;
                }
                if (i == 0){
                    matrix[i][j] ^= matrix[i][j-1];
                }
                else if (j == 0){
                    matrix[i][j] ^= matrix[i-1][j];
                }
                else {
                    matrix[i][j] ^= (matrix[i-1][j] ^ matrix[i][j-1] ^ matrix[i-1][j-1]);
                }
                xors[index++] = matrix[i][j];
            }
        }

        return findKthLargest(xors, k);
    }
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, l);
        int pivot = a[l];
        int lt = l;
        for (int j = l + 1; j <= r; ++j) {
            if (a[j] <= pivot) {
                swap(a, ++lt, j);
            }
        }
        swap(a, lt, l);
        return lt;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
