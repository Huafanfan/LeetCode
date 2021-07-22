package byteDance;

public class RemoveDuplicatesFromSortedListIi {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null){
            if (cur.next.val == cur.next.next.val){
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val){
                    cur.next = cur.next.next;
                }
            }
            else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        RemoveDuplicatesFromSortedListIi removeDuplicatesFromSortedListIi = new RemoveDuplicatesFromSortedListIi();
        System.out.println(removeDuplicatesFromSortedListIi.deleteDuplicates(listNode1));
    }
}
