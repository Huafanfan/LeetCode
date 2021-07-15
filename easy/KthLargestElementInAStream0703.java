package easy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/14 15:34
 */
public class KthLargestElementInAStream0703 {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargestElementInAStream0703(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
