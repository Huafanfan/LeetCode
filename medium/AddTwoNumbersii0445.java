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
       ListNode result = new ListNode(-1);
       result.next = null;
        while (l1!=null){
            numList1.addLast(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            numList2.addLast(l2.val);
            l2 = l2.next;
        }
        int weight = 0;
        while (!numList1.isEmpty()||!numList2.isEmpty()||weight!=0){
            int num1 = numList1.isEmpty()?0:numList1.removeLast();
            int num2 = numList2.isEmpty()?0:numList2.removeLast();
            int num3 = (num1+num2+weight)%10;
            weight = (num1+num2+weight)/10;
            ListNode temp = new ListNode(num3);
            temp.next = result.next;
            result.next = temp;
        }
        return result.next;
    }
}
