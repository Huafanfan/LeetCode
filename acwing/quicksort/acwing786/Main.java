package acwing.quicksort.acwing786;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/29 16:49
 */
public class Main {
    /**
     * 快速选择算法
     */

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int k = in.nextInt();

        int[] nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }

        System.out.print(quickSort(nums, 0, n-1, k));
    }

    public static int quickSort(int[] nums, int l, int r, int k){
        if (l == r) {
            return nums[l];
        }
        int x = nums[l], i = l-1, j = r + 1;
        while (i < j){
            while (nums[++i] < x) {
                ;
            }
            while (nums[--j] > x) {
                ;
            }
            if (i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        int sl = j - l + 1;
        if (k <= sl){
            return quickSort(nums, l, j, k);
        } else {
            return quickSort(nums, j+1, r, k-sl);
        }
    }
}
