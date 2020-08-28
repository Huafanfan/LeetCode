package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/28 14:20
 */
public class AddTwoNumbersii0445 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> numList1 = new ArrayDeque<>();
        Deque<Integer> numList2 = new ArrayDeque<>();
        while (l1!=null){
            numList1.addLast(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            numList2.addLast(l2.val);
            l2 = l2.next;
        }
        while (!numList1.isEmpty()||!numList2.isEmpty()){
            int num1 = numList1.isEmpty()?0:numList1.removeLast();
            int num2 = numList2.isEmpty()?0:numList2.removeLast();
        }
    }
}
