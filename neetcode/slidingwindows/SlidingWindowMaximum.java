package neetcode.slidingwindows;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/6 11:44
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        // index
        Deque<Integer> deque = new ArrayDeque<>();
        int l=0, r=0;
        while (r < nums.length){
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[r]){
                deque.pollLast();
            }
            deque.addLast(r);

            if (l > deque.getFirst()){
                deque.pollFirst();
            }

            if (r + 1 >= k){
                res[index++] = nums[deque.getFirst()];
                l++;
            }
            r++;

        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums, 3)));
    }
}
