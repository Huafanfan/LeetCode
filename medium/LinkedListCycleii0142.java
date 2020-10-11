package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/11 09:05
 */
public class LinkedListCycleii0142 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null){
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next.next;
            }
            else {
                return null;
            }
            if (slow == fast){
                ListNode ptr = head;
                while (ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
