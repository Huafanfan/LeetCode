package byteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/8/1 21:07
 */
public class ReorderList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        int l = 0;
        int r = list.size() - 1;
        boolean ifLeft = true;
        while (l < r){
            if (ifLeft){
                list.get(l).next = list.get(r);
                l++;
                ifLeft = false;
            }
            else {
                list.get(r).next = list.get(l);
                r--;
                ifLeft = true;
            }
        }
        list.get(l).next = null;
    }
}
