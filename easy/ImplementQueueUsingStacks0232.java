package easy;

import java.util.Stack;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/21 10:12
 */
public class ImplementQueueUsingStacks0232 {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    private int front;

    public void push(int x) {
        if (s1.empty()) {
            front = x;
        }
        s1.push(x);
    }

    public void pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        s2.pop();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

}
