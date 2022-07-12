package neetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/12 11:41
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSort(nums, 0, n-1, n - k + 1);
    }

    public int quickSort(int[] nums, int l, int r, int k){
        if (l == r){
            return nums[l];
        }
        int x = nums[l], i = l-1, j = r + 1;
        while (i < j){
            while (nums[i++] < x);
            while (nums[j--] > x);
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
            return quickSort(nums, j+1, r, k - sl);
        }
    }

    public int findKthLargest2(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i=0; i<k; i++){
            queue.offer(nums[i]);
        }
        for (int i=k; i<nums.length; i++){
            queue.offer(nums[i]);
            queue.poll();
        }
        return queue.peek();
    }
}
