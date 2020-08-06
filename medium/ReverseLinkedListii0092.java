package medium;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/6 10:32
 */
public class ReverseLinkedListii0092 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dumb = new ListNode(-1);
        dumb.next = head;
        ListNode pre = dumb;
        ListNode reverseHead = new ListNode(-1);
        ListNode reverseTail = new ListNode(-1);
        int start = 1;
        while (head!=null){
            ListNode tmp = head.next;
            if (start == m){
                reverseHead.next = head;
                reverseTail = reverseHead.next;
            }
            else if (start > m && start <= n){
                head.next = reverseHead.next;
                reverseHead.next = head;
            }
            else if(start>n){
                reverseTail.next = head;
                break;
            }
            else {
                pre = pre.next;
            }
            head = tmp;
            if (head!=null){
                start++;
            }
        }
        if (start == n){
            reverseTail.next = null;
        }
        pre.next = reverseHead.next;
        return dumb.next;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (m > 1) {
            prev = prev.next;
            m--;
            n--;
        }
        head = prev.next;
        while (n > 1) {
            ListNode next = head.next;
            head.next = head.next.next;
            next.next = prev.next;
            prev.next = next;
            n--;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseLinkedListii0092 reverseLinkedListii0092 = new ReverseLinkedListii0092();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = reverseLinkedListii0092.reverseBetween(head,2,4);
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
