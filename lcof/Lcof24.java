package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/16 14:31
 */
public class Lcof24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 100.00%
     * 71.73%
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head!=null){
            ListNode nextNode = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = nextNode;
        }
        return dummy.next;
    }

    /**
     * 100.00%
     * 52.79%
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head==null || head.next == null){
            return head;
        }
        ListNode ret = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }


}
