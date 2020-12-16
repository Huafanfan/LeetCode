package lcof;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/16 17:09
 */
public class Lcof30 {
    Deque<Integer> stackA;
    Deque<Integer> stackB;

    /**
     * 33.57%
     * 94.36%
     */
    public Lcof30() {
        stackA = new LinkedList<>();
        stackB = new LinkedList<>();
    }

    public void push(int x) {
        stackA.offerLast(x);
        if (stackB.isEmpty() || stackB.peekLast() >= x){
            stackB.offerLast(x);
        }
        else {
            stackB.offerLast(stackB.peekLast());
        }
        //if (stackB.isEmpty() || stackB.peekLast() >= x){
        //    stackB.offerLast(x);
        //}
    }

    public void pop() {
        stackA.pollLast();
        stackB.pollLast();
        //if (Objects.equals(stackA.pollLast(), stackB.peekLast())){
        //    stackB.pollLast();
        //}
    }

    public int top() {
        return stackA.peekLast();
    }

    public int min() {
        return stackB.peekLast();
    }
}
