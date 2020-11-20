package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/20 09:43
 */
public class InsertionSortList0147 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode insertionSortList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode dump = new ListNode(Integer.MIN_VALUE);
        dump.next = head;
        ListNode end = dump.next;
        head = head.next;
        while (head != null){
            ListNode start = dump;
            ListNode newStart = head.next;
            while (start.val != end.val){
                if (start.next != null){
                    if (start.val<head.val&&start.next.val<head.val){
                        start = start.next;
                    }
                    else if (start.val<=head.val&&start.next.val>=head.val){
                        head.next = start.next;
                        start.next = head;
                        end.next = newStart;
                        break;
                    }
                }
            }
            if (start.val == end.val){
                end = end.next;
                end.next = newStart;
            }
            head = newStart;
        }
        return dump.next;
    }

    public ListNode insertionSortList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        InsertionSortList0147 insertionSortList0147 = new InsertionSortList0147();
        //ListNode node1 = new ListNode(4);
        //ListNode node2 = new ListNode(2);
        //ListNode node3 = new ListNode(1);
        //ListNode node4 = new ListNode(3);
        //node1.next = node2;
        //node2.next = node3;
        //node3.next = node4;
        //node4.next = null;
        //ListNode node1 = new ListNode(-1);
        //ListNode node2 = new ListNode(5);
        //ListNode node3 = new ListNode(3);
        //ListNode node4 = new ListNode(4);
        //ListNode node5 = new ListNode(0);
        //node1.next = node2;
        //node2.next = node3;
        //node3.next = node4;
        //node4.next = node5;
        //node5.next = null;
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        node2.next = null;
        ListNode result = insertionSortList0147.insertionSortList(node1);
        System.out.println(result.val);

    }
}
