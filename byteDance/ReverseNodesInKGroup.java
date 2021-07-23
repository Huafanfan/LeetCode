package byteDance;

import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/23 12:08
 */
public class ReverseNodesInKGroup {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null){
            for (int i=0 ;i < k && end != null; i++){
                end = end.next;
            }
            if (end == null){
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;

            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode node){
        ListNode head = null;
        while (node != null){
            ListNode next = node.next;
            node.next = head;
            head = node;
            node = next;
        }
        return head;
    }
}
