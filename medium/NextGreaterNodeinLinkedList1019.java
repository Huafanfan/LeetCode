package medium;

import javax.swing.*;
import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/10 11:24
 */
public class NextGreaterNodeinLinkedList1019 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int[] nextLargerNodes(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> data = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        int index = 0;
        while(head != null) {
            res.add(0);
            data.add(head.val);

            while (!stack.isEmpty() && head.val > data.get(stack.peek())) {
                res.set(stack.pop(), head.val);
            }

            stack.push(index);
            index++;
            head = head.next;
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
