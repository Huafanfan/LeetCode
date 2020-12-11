package lcof;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/11 15:14
 */
public class Lcof06 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 72.21%
     * 65.97%
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head!=null){
            deque.offer(head);
            head = head.next;
        }
        int[] result = new int[deque.size()];
        for (int i=0; i<result.length; i++){
            result[i] = Objects.requireNonNull(deque.pollLast()).val;
        }
        return result;
    }

    /**
     * 100.00%
     * 58.31%
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        ListNode cur = head;
        int length = 0;
        while (cur!=null){
            length++;
            cur = cur.next;
        }
        int[] result = new int[length];
        while (head!=null){
            result[length--] = head.val;
            head = head.next;
        }
        return result;
    }
}
