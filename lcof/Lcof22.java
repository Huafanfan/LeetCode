package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/16 11:36
 */
public class Lcof22 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (k>0 && fast != null) {
            fast = fast.next;
            k--;
        }
        if (k>0){
            return null;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.next;
    }

    public static void main(String[] args) {
        Lcof22 lcof22 = new Lcof22();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        lcof22.getKthFromEnd(node1, 5);

    }
}
