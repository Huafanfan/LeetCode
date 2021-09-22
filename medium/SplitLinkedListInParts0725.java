package medium;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/22 09:23
 */
public class SplitLinkedListInParts0725 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        int eachGroup = count / k;
        int remain = count % k;
        ListNode[] res = new ListNode[k];
        cur = head;
        for (int i=0; i<k && cur != null; i++){
            res[i] = cur;
            int partCount = eachGroup + (i < remain ? 1 : 0);
            for (int j = 1; j < partCount; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }

    public ListNode[] splitListToParts2(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int quotient = n / k, remainder = n % k;

        ListNode[] parts = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            parts[i] = curr;
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return parts;
    }

    public static void main(String[] args) {
        SplitLinkedListInParts0725 splitLinkedListInParts0725 = new SplitLinkedListInParts0725();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        //ListNode node4 = new ListNode();
        //ListNode node5 = new ListNode();
        node1.next = node2;
        node2.next = node3;
        System.out.println(Arrays.toString(splitLinkedListInParts0725.splitListToParts(node1, 5)));

    }
}
