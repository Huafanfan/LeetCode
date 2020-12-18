package lcof;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/18 15:11
 */
public class Lcof40 {
    /**
     * 29.45%
     * 93.63%
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if (k > arr.length || k == 0){
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            res[i] = queue.poll();
        }
        return res;
    }

    /**
     * 99.37%
     * 94.49%
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        quicksort(arr, 0, arr.length - 1, k);
        int[] vec = new int[k];
        if (k >= 0) {
            System.arraycopy(arr, 0, vec, 0, k);
        }
        return vec;
    }

    public void quicksort(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = partition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            quicksort(arr, l, pos - 1, k);
        } else {
            quicksort(arr, pos + 1, r, k - num);
        }
    }

    public int partition(int[] nums, int l, int r) {
        int randomIndex = new Random().nextInt(r - l + 1) + l;
        swap(nums, l, randomIndex);
        int pivot = nums[l];

        int lt = l;
        for (int j = l + 1; j <= r; ++j) {
            if (nums[j] <= pivot) {
                lt++;
                swap(nums, lt, j);
            }
        }
        swap(nums, l, lt);
        return lt;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        Lcof40 lcof40 = new Lcof40();
        int[] arr = new int[]{4,5,1,6,2,7,3,8};
        lcof40.getLeastNumbers2(arr,4);
    }
}
