package medium;

public class RemoveZeroSumConsecutiveNodesFromLinkedList1171 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null){
            int sum = 0;
            while (cur != null){
                sum += cur.val;
                cur = cur.next;
                if (sum == 0){
                    break;
                }
            }
            if (sum == 0){
                pre.next = cur;
            }
            else {
                pre = pre.next;
                cur = pre.next;
            }
        }
        return dummy.next;
    }

    public ListNode removeZeroSumSublists2(ListNode head) {
        if (head == null) return null;
        int sum = 0;
        for (ListNode cursor = head; cursor != null; cursor = cursor.next){
            if ((sum += cursor.val) == 0){
                return removeZeroSumSublists2(cursor.next);
            }
        }
        head.next = removeZeroSumSublists2(head.next);
        return head;
    }

}
