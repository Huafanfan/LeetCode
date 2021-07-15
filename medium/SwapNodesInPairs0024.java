package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/27 14:06
 */
public class SwapNodesInPairs0024 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode first = head.next;
        ListNode second = head;
        while (first!=null){
            pre.next = first;
            second.next = first.next;
            first.next = second;
            if (second.next==null){
                return dummy.next;
            }
            pre=second;
            second=second.next;
            first=second.next;
        }
        return dummy.next;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode secondNode = head.next;

        // Swapping
        head.next  = swapPairs2(secondNode.next);
        secondNode.next = head;

        // Now the head is the second node
        return secondNode;
    }
}
