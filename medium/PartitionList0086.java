package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/5 15:42
 */
public class PartitionList0086 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode slow = new ListNode(-1);
        ListNode slowHead = slow;
        ListNode fast = new ListNode(-1);
        ListNode fastHead = fast;
        while (head!=null){
            if (head.val<x){
                slow.next = head;
                slow = slow.next;
            }
            else {
                fast.next = head;
                fast = fast.next;
            }
            head = head.next;
        }
        fast.next=null;
        slow.next = fastHead.next;
        return slowHead.next;
    }
}
