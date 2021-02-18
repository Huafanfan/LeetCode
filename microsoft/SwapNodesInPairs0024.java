package microsoft;

public class SwapNodesInPairs0024 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null){
            ListNode nex = head.next;
            if (nex == null){
                break;
            }
            head.next = head.next.next;
            nex.next = head;
            pre.next = nex;
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        SwapNodesInPairs0024 swapNodesInPairs0024 = new SwapNodesInPairs0024();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        swapNodesInPairs0024.swapPairs(node1);
    }
}
