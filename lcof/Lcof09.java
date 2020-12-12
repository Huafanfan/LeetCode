package lcof;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/12 10:29
 */
public class Lcof09 {
    Deque<Integer> master;
    Deque<Integer> slave;

    /**
     * 77.48%
     * 14.98%
     */
    public Lcof09() {
        master = new LinkedList<>();
        slave = new LinkedList<>();
    }

    public void appendTail(int value) {
        master.push(value);
    }

    public int deleteHead() {
        if (slave.isEmpty()) {
            while (!master.isEmpty()) {
                slave.push(master.pop());
            }
        }
        if (slave.isEmpty()) {
            return -1;
        } else {
            return slave.pop();
        }
    }
}
