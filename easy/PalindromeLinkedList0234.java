package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/23 10:09
 */
public class PalindromeLinkedList0234 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null){
            list.add(current.val);
            current = current.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left <= right){
            if (!list.get(left++).equals(list.get(right--))) {
                return false;
            }
        }
        return true;
    }
}
