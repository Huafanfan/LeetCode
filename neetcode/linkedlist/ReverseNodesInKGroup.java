package neetcode.linkedlist;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/22 11:20
 */
public class ReverseNodesInKGroup {
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
            pre.next = reverseList(start);
            start.next = next;

            pre = start;
            end = pre;

        }
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null){
            ListNode cur = head;
            head = head.next;
            cur.next = dummy.next;
            dummy.next = cur;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode groupPre = dummy;
        while (true){
            ListNode kth = getKth(groupPre, k);
            if (kth == null){
                break;
            }
            ListNode groupNext = kth.next;

            ListNode pre = groupNext, cur = groupPre.next;
            while (cur != groupNext){
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }

            ListNode tmp = groupPre.next;
            groupPre.next = kth;
            groupPre = tmp;
        }
        return dummy.next;
    }

    public ListNode getKth(ListNode node , int k){
        while (node != null && k-- > 0){
            node = node.next;
        }
        return node;
    }
}
