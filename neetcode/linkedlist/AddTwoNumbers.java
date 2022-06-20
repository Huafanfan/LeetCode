package neetcode.linkedlist;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/20 12:18
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0){
            return null;
        }
        ListNode node = new ListNode();
        if (l1 == null && l2 == null){
            node.val = carry;
            return node;
        } else if (l1 != null && l2 == null){
            node.val = (l1.val + carry) % 10;
            node.next = addTwoNumbers(l1.next, null, (l1.val + carry)/10);
            return node;
        } else if (l1 == null){
            node.val = (l2.val + carry) % 10;
            node.next = addTwoNumbers(null, l2.next, (l2.val + carry)/10);
            return node;
        } else {
            node.val = (l1.val + l2.val + carry) % 10;
            node.next = addTwoNumbers(l1.next, l2.next, (l1.val + l2.val + carry)/10);
            return node;
        }
    }
}
