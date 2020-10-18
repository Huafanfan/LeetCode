package com.huafanfan.medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/27 11:34
 */
public class RemoveNthNodeFromEndofList0019 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy =new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        while (n>=0){
            first = first.next;
            n--;
        }
        //for (int i = 1; i <= n + 1; i++) {
        //    first = first.next;
        //}
        while (first!=null){
            second=second.next;
            first=first.next;
        }
        second.next=second.next.next;
        return dummy.next;
    }
}
