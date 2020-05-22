package com.huafanfan;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/20 14:27
 */
public class RemoveLinkedListElements0203 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 迭代
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode(0);
        start.next=head;
        ListNode pre = start;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return start.next;
    }

    /**
     * 递归
     */
    public ListNode removeElementsRecursive(ListNode head, int val) {
        if(head==null){
            return null;
        }
        head.next = removeElementsRecursive(head.next,val);
        return head.val==val?head.next:head;
    }

}
