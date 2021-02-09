package microsoft;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/8 18:49
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers0002 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return dfs(l1, l2, 0);
    }

    public ListNode dfs(ListNode l1, ListNode l2, int carry){
        if (l1 == null && l2 == null && carry == 0){
            return null;
        }
        int value = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
        ListNode cur = new ListNode(value % 10);
        cur.next = dfs(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value/10);
        return cur;
    }
}
