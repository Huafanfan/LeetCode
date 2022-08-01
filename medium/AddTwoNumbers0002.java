package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/23 10:58
 */
public class AddTwoNumbers0002 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode curNode = root;
        int carry = 0;
        while (l1!=null||l2!=null||carry!=0){
            int l1Val = l1!=null?l1.val:0;
            int l2Val = l2!=null?l2.val:0;
            int sumVal = l1Val+l2Val+carry;
            carry = sumVal/10;
            ListNode sumNode = new ListNode(sumVal%10);
            curNode.next = sumNode;
            curNode = sumNode;

            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        return root.next;
    }

}
