package lcof;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/23 09:44
 */
public class Lcof59I {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0){
            return new int[]{};
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        for (int i=1; i<n; i++){
            if (i % k == 0){
                left[i] = nums[i];
            }else {
                left[i] = Math.max(nums[i], left[i-1]);
            }

            int j = n - i - 1;
            if ((j + 1) % k == 0){
                right[j] = nums[j];
            }
            else {
                right[j] = Math.max(nums[j], right[j+1]);
            }
        }
        int[] res = new int[n-k+1];
        for (int i=0; i<res.length; i++){
            res[i] = Math.max(right[i], left[i+k]);
        }
        return res;
    }
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        // 形成窗口后
        for(int i = k; i < nums.length; i++) {
            if(deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }


    public static void main(String[] args) {
        Lcof59I lcof59I = new Lcof59I();
        int[] nums = new int[]{1,3,-3,-1,5,3,6,7};
        lcof59I.maxSlidingWindow2(nums, 3);
    }
}
