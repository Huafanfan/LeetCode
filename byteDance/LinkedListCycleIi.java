package byteDance;

public class LinkedListCycleIi {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null){
            slow = slow.next;
            if (fast.next!=null){
                fast = fast.next.next;
            }
            else {
                return null;
            }
            if (fast == slow){
                ListNode start = head;
                while (start != slow){
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }
        return null;
    }
}
