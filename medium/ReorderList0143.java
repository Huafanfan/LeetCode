package medium;

import java.util.Stack;
import java.util.TooManyListenersException;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/20 09:19
 */
public class ReorderList0143 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head) {
        if (head==null || head.next==null || head.next.next==null){
            return;
        }
        Stack<ListNode> listNodes = new Stack<>();
        ListNode curr = head.next;
        while (curr!=null){
            listNodes.push(curr);
            curr = curr.next;
        }
        boolean isOdd = listNodes.size() % 2 != 0;
        int epoch = listNodes.size() / 2;
        curr = head;
        while (epoch > 0){
            ListNode temp = listNodes.pop();
            temp.next = curr.next;
            curr.next = temp;
            curr = curr.next.next;
            epoch--;
        }
        if (isOdd){
            curr.next = listNodes.pop();
        }
        else {
            ListNode temp = listNodes.pop();
            temp.next = curr.next;
            curr.next = temp;
        }
        curr.next.next = null;
    }

    public void reorderList2(ListNode head) {
        if (head==null || head.next==null || head.next.next==null){
            return;
        }
        ListNode temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next.next = head.next;
        head.next = temp.next;
        temp.next = null;
        reorderList2(head.next.next);
    }

}
