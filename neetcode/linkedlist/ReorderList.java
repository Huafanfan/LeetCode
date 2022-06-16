package neetcode.linkedlist;

import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/16 11:59
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null;
        while (second != null){
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        ListNode first = head;
        second = prev;

        while (second != null){
            ListNode temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}
