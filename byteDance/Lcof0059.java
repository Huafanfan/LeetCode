package byteDance;

import java.util.Deque;
import java.util.LinkedList;

public class Lcof0059 {
    Deque<Integer> queue;
    Deque<Integer> maxQueue;
    public Lcof0059() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()){
            return -1;
        }
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while(!maxQueue.isEmpty() && maxQueue.peekLast() < value){
            maxQueue.pollLast();
        }
        maxQueue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        if (maxQueue.peek().equals(queue.peek())){
            maxQueue.poll();
        }
        return queue.poll();
    }
}
