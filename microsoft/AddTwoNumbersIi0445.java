package microsoft;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/16 21:28
 */
public class AddTwoNumbersIi0445 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null){
            stack1.addLast(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.addLast(l2.val);
            l2 = l2.next;
        }
        ListNode head = new ListNode(0);
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int num1 = stack1.isEmpty() ? 0 : stack1.removeLast();
            int num2 = stack2.isEmpty() ? 0 : stack2.removeLast();
            int newNum = num1 + num2 + carry;
            ListNode node = new ListNode(newNum % 10);
            carry = newNum / 10;
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }
}
