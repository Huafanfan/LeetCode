package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/9 09:06
 */
public class LinkedListCycle0141 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes  = new HashSet<>();
        while (head!=null){
            if (!nodes.contains(head)){
                nodes.add(head);
                head = head.next;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleTwoPoint(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
