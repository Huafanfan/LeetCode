package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/11/2 10:04
 */
public class DeleteNodeInALinkedList0237 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
