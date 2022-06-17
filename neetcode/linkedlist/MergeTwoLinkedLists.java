package neetcode.linkedlist;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/16 11:48
 */
public class MergeTwoLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode last = dummy;
        while (list1 != null || list2 != null){
            if (list1 == null){
                last.next = list2;
                break;
            } else if (list2 == null){
                last.next = list1;
                break;
            }
            if (list1.val <= list2.val){
                last.next = list1;
                list1 = list1.next;
            } else {
                last.next = list2;
                list2 = list2.next;
            }
            last = last.next;
        }
        return dummy.next;
    }
}
