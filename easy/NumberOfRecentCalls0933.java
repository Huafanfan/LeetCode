package easy;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/6 10:40
 */
public class NumberOfRecentCalls0933 {
    Queue<Integer> queue;
    public NumberOfRecentCalls0933() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (!queue.isEmpty() && queue.peek() < t - 3000){
            queue.poll();
        }
        return queue.size();
    }
}
