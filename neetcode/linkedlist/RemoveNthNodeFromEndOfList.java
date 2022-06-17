package neetcode.linkedlist;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/17 10:11
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (n-- > 0){
            fast = fast.next;
        }
        while (fast.next!= null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
