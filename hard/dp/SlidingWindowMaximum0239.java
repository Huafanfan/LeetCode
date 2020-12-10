package hard.dp;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/10 11:45
 */
public class SlidingWindowMaximum0239 {
    /**
     * 暴力，无意义
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }

        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }

    /**
     * 双向队列
     */
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        // init deque and output
        this.nums = nums;
        int maxIdx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        int [] output = new int[n - k + 1];
        output[0] = nums[maxIdx];

        // build output
        for (int i  = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }
        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.removeLast();
        }
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        if(n * k == 0){
            return new int[0];
        }
        if (k == 1){
            return nums;
        }
        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n-1] = nums[n-1];
        for (int i=1; i<n; i++){
            if (i % k == 0){
                left[i] = nums[i];
            }
            else {
                left[i] = Math.max(nums[i], left[i-1]);
            }

            int j = n-i-1;
            if (j % k == 0){
                right[j] = nums[j];
            }
            else {
                right[j] = Math.max(nums[j], right[j+1]);
            }
        }
        //right[i] 是左侧块内的最大元素， left[j] 是右侧块内的最大元素。因此滑动窗口中的最大元素为 max(right[i], left[j])
        int[] output = new int[n-k+1];
        for (int i=0; i<n-k+1; i++){
            output[i] = Math.max(left[i+k-1],right[i]);
        }
        return output;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        SlidingWindowMaximum0239 slidingWindowMaximum0239 = new SlidingWindowMaximum0239();
        System.out.println(Arrays.toString(slidingWindowMaximum0239.maxSlidingWindow2(nums, 3)));
    }
}
