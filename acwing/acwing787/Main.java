package acwing.acwing787;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/30 10:49
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

        mergeSort(nums, tmp, 0, n-1);

        for (int i=0; i<n; i++){
            System.out.print(nums[i] + " ");
        }
    }

    private static void mergeSort(int[] nums, int[] tmp, int l, int r) {
        if (l >= r){
            return;
        }
        int mid = l + r >> 1;
        mergeSort(nums, tmp, l, mid);
        mergeSort(nums, tmp, mid + 1, r);
        int index = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r){
            if (nums[i] <= nums[j]){
                tmp[index++] = nums[i++];
            } else {
                tmp[index++] = nums[j++];
            }
        }
        while (i <= mid){
            tmp[index++] = nums[i++];
        }
        while (j <= r){
            tmp[index++] = nums[j++];
        }
        for (i=l, j=0; i<=r; i++,j++){
            nums[i] = tmp[j];
        }

    }
}
