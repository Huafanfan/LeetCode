package lcof;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/23 11:03
 */
public class Lcof59II {
    Deque<Integer> deque;
    Deque<Integer> maxDeque;

    public Lcof59II() {
        deque = new LinkedList<>();
        maxDeque = new LinkedList<>();
    }

    public int max_value() {
        return maxDeque.isEmpty() ? -1 : maxDeque.peekFirst();
    }

    public void push_back(int value) {
        while (!maxDeque.isEmpty() && maxDeque.peekLast() < value){
            maxDeque.pollLast();
        }
        maxDeque.offerLast(value);
        deque.offerLast(value);
    }

    public int pop_front() {
        if (deque.isEmpty()){
            return -1;
        }
        int popNum = deque.pollFirst();
        if (Objects.equals(popNum, maxDeque.peekFirst())){
            maxDeque.pollFirst();
        }
        return popNum;
    }
}
