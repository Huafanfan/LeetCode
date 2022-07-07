package neetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/7 12:35
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : stones){
            queue.add(num);
        }
        while (queue.size() > 1){
            int a = queue.poll();
            int b = queue.poll();
            if (a != b){
                queue.add(a - b);
            }
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }
}
