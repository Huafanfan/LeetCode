package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/20 15:02
 */
public class ReverseLinkedList0206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 迭代
     * 时间复杂度：O(n)，假设 n 是列表的长度，时间复杂度是 O(n)。
     * 空间复杂度：O(1)。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        ListNode newList = null;
        while (cur!=null){
            next = cur.next;
            cur.next=newList;
            newList=cur;
            cur=next;

        }
        return newList;
    }

    /**
     * 递归
     * 时间复杂度：O(n)，假设 n 是列表的长度，那么时间复杂度为 O(n)。
     * 空间复杂度：O(n)，由于使用递归，将会使用隐式栈空间。递归深度可能会达到 n 层。
     * @param head
     * @return
     */
    public ListNode reverseListRecursive(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode p=reverseListRecursive(head.next);
        head.next.next=head;
        head.next=null;
        return p;
    }


}
