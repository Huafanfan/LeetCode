package com.huafanfan.medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/27 14:06
 */
public class SwapNodesInPairs0024 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode dommy = new ListNode(0);
        dommy.next = head;
        //ListNode first = head.next;
        //ListNode second = dommy;
        //ListNode temp = new ListNode(-1);
        //while (first!=null){
        //    temp = second.next;
        //    second.next=first;
        //    temp.next=first.next;
        //    first.next=temp;
        //    if (temp.next==null){
        //        return dommy.next;
        //    }
        //    first=temp.next.next;
        //    second=temp;
        //}
        ListNode pre = dommy;
        ListNode first = head.next;
        ListNode second = head;
        while (first!=null){
            pre.next = first;
            second.next = first.next;
            first.next = second;
            if (second.next==null){
                return dommy.next;
            }
            pre=second;
            second=second.next;
            first=second.next;
        }
        return dommy.next;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode secondNode = head.next;

        // Swapping
        head.next  = swapPairs2(secondNode.next);
        secondNode.next = head;

        // Now the head is the second node
        return secondNode;
    }
}
