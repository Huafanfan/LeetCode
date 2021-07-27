package byteDance;

public class MergeInBetweenLinkedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode();
        dummy.next = list1;
        ListNode start = dummy;
        ListNode end;
        int length = b - a + 1;
        while (a > 0 && start != null){
            start = start.next;
            a--;
        }
        if (start == null){
            return list1;
        }
        end = start;
        while (length > 0 && end != null){
            end = end.next;
            length--;
        }
        if (end == null){
            return list1;
        }
        ListNode end2 = list2;
        while (end2.next != null){
            end2 = end2.next;
        }
        start.next = list2;
        end2.next = end.next;
        return list1;
    }
}
