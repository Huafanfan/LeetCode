package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/13 10:57
 */
public class Lcof18 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 100.00%
     * 92.36%
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode lastNode = dummy;
        while (head!=null){
            if (head.val == val){
                lastNode.next = head.next;
                head = head.next;
            }else {
                head = head.next;
                lastNode = lastNode.next;
            }
        }
        return dummy.next;
    }

    /**
     * 排序删除相同
     * @param head
     * @return
     */
    public ListNode deleteNode(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode lastNode = head;
        ListNode cur = head.next;
        while (cur!=null){
            if (cur.val == lastNode.val){
                lastNode.next = cur.next;
                cur = cur.next;
            }else {
                cur = cur.next;
                lastNode = lastNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Lcof18 lcof18 = new Lcof18();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        lcof18.deleteNode(n1);
    }
}
