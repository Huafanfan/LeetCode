package neetcode.linkedlist;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/15 11:39
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode dumb = new ListNode();
        while (head != null){
            ListNode cur = head;
            head = head.next;
            cur.next = dumb.next;
            dumb.next = cur;
        }
        return dumb.next;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
