package neetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/7 12:17
 */
public class KthLargestElementInAStream {
    Queue<Integer> queue = new PriorityQueue<>();
    int K;
    public KthLargestElementInAStream(int k, int[] nums) {
        K = k;
        for (int num : nums){
            add(num);
        }
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > K){
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 5, 8};
        KthLargestElementInAStream k = new KthLargestElementInAStream(3, nums);
        System.out.println(k.add(8));

    }
}
