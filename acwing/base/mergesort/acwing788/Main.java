package acwing.base.mergesort.acwing788;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/30 11:54
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] tmp = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }

        System.out.println(mergeSort(nums, tmp, 0, n-1));
    }

    private static long mergeSort(int[] nums, int[] tmp, int l, int r) {
        if (l >= r){
            return 0;
        }
        int mid = l + r >> 1;
        long res = mergeSort(nums, tmp, l, mid) + mergeSort(nums, tmp, mid+1, r);

        int k=0, i = l, j = mid + 1;
        while (i <= mid && j <= r){
            if (nums[i] <= nums[j]){
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
                res += mid - i + 1;
            }
        }
        while (i <= mid){
            tmp[k++] = nums[i++];
        }
        while (j <= r){
            tmp[k++] = nums[j++];
        }
        for (i=l, j=0; i<=r; i++,j++){
            nums[i] = tmp[j];
        }
        return res;
    }
}
