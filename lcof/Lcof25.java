package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/16 14:40
 */
public class Lcof25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 98.63%
     * 73.11%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1!=null || l2!=null){
            if (l1 == null){
                cur.next = l2;
                break;
            }
            else if (l2 == null){
                cur.next = l1;
                break;
            }
            else {
                if (l1.val <= l2.val){
                    cur.next = l1;
                    l1 = l1.next;
                }
                else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * 98.63%
     * 61.52%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        if(l1.val<l2.val)
        {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }
        else
        {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }

    }
}
