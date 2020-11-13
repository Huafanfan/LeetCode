package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/21 16:14
 */
public class OddEvenLinkedList0328 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode oddEvenList1(ListNode head) {
        ListNode oddHead = new ListNode();
        ListNode evenHead = new ListNode();
        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;
        int isOdd = 1;
        while (head!=null){
            if (isOdd==1){
                oddTail.next = head;
                oddTail = oddTail.next;
            }
            else {
                evenTail.next = head;
                evenTail = evenTail.next;
            }
            head = head.next;
            isOdd = (isOdd+1) & 1;
        }
        oddTail.next = evenHead.next;
        evenTail.next=null;
        return oddHead.next;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
