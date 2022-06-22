package neetcode.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/22 10:54
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        List<ListNode> listNodes = new ArrayList<>();
        Collections.addAll(listNodes, lists);
        while (listNodes.size() > 1){
            List<ListNode> temp = new ArrayList<>();
            for (int i=0; i<listNodes.size(); i = i + 2){
                ListNode list1 = listNodes.get(i);
                ListNode list2 = i + 1 == listNodes.size() ? null : listNodes.get(i + 1);
                temp.add(mergeTwoLists(list1, list2));
            }
            listNodes = temp;
        }
        return listNodes.get(0);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
