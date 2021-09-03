package medium;

import java.util.Random;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/3 11:00
 */
public class SmallestKLcci0017 {
    public int[] smallestK(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        if (k >= 0) {
            System.arraycopy(arr, 0, res, 0, k);
        }
        return res;
    }

    private void quickSort(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return;
        }

        int pIndex = partition(nums, left, right);
        int num = pIndex - left + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            quickSort(nums, left, pIndex - 1, k);
        } else {
            quickSort(nums, pIndex + 1, right, k - num);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums, left, lt);
        return lt;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
